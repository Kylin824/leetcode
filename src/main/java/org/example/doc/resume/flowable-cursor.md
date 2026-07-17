# 企业 OA 工作流引擎平台（简历素材）

> 基于 bigo-oa-pro / `flowable` 模块实查整理  
> 技术栈：Flowable 6.7.1 · Spring Boot · Redis · XXL-JOB · MyBatis-Plus · Java 8

---

## 一、可直接粘贴的简历内容

### 项目名称（选一）

- 企业 OA 工作流引擎平台
- 基于 Flowable 的 OA 审批中台
- 统一工作流引擎

### 项目描述

负责公司 OA 多模块单体仓中的工作流核心模块，基于 Flowable 6.7.1 构建统一审批引擎，覆盖提交、审批、驳回、取回、终止、转办、改签等全生命周期；通过生命周期 SPI + 责任链将近 30 类业务单据（预算、发票、虚拟币、人事等）与引擎解耦接入；配套主单级 Redis 互斥锁、异步审批、自动审批策略及在途流程定义热升级，支撑生产环境流程运维与扩展。

### 职责与成果（建议挑 4～6 条）

1. 设计并实现基于 Flowable 的 OA 流程中台，统一封装提交/审批/取回/终止/转办/改签等操作，对外提供标准化 REST 接口，支撑预算、发票、币商、人事等业务线接入。
2. 抽象 FlowLifeCycleService SPI 与责任链装配机制，业务侧仅实现生命周期钩子即可扩展新流程，降低引擎层改动成本，已落地近 30 个业务生命周期实现。
3. 基于主单级 Redis 分布式锁统一并发控制入口，避免多端同时审批/提交导致的状态不一致；审批路径支持同步校验 + 异步执行，提升批量审批吞吐。
4. 基于 ProcessMigrationService 实现在途流程定义热升级（先校验再迁移），并配合 XXL-JOB 批量升级审批中/驳回态实例，保障 BPMN 变更可平滑上线。
5. 深度定制引擎：自定义 ActivityBehavior、BPMN ParseHandler、EventListener、会签/排他网关行为；关闭引擎内置异步执行器，将运维型异步统一交由 XXL-JOB / 业务线程池。
6. 建设自动审批与补偿任务体系（同人免重复审、业务 Handler 策略扩展），覆盖部署、自动审批、记录清理、预算占用修复等生产运维场景。

### 一句话版本（可压缩）

负责公司 OA 工作流中台：基于 Flowable 6.7.1 封装提交/审批/驳回/取回/终止/转办等全生命周期，用 LifeCycle SPI + 责任链接入近 30 类审批单；自研主单 Redis 锁、任务镜像与规则配置；实现基于 ProcessMigrationService 的在途版本升级（手工 + XXL 批量）；并以 XXL-JOB 驱动自动审批与业务补偿。

---

## 二、规模信号（可量化）

| 指标 | 数量（约） |
|------|-----------|
| BPMN 文件 | 33 |
| 业务流程类型 | ~29 |
| 业务 LifeCycle 实现 | ~29–30 |
| Controller | 12 |
| XXL-JOB 入口 | 16 |
| AutoAudit Handler | ~18 |
| 模块 Java 源文件 | ~292 |

业务域覆盖：预算全族、发票、币商/虚拟币支付与纠错、广告充值、佣金、人事（调班/销假/银行卡/岗位）、资产确认、出差补贴等。

---

## 三、架构要点

### 3.1 定位

`flowable` 是 bigo-oa-pro Maven 多模块仓中的 **OA 审批/流程引擎核心实现层**，由 `start` 聚合启动。流程契约（`FlowBasicData`、`FlowStatus`、`FlowKeyEnum` 等）下沉在 `api` / `api-po`，业务模块通过生命周期回调接入，而不是各自直接操作引擎。

### 3.2 分层：OA 壳 + Flowable 核

```
Controller
  → Process XxxService（加锁 + 事务）
    → RuntimeService / TaskService / Command
      → FlowLifeCycleServiceChain（通用钩子 + 业务钩子）
        → 更新主表 / 任务镜像 / 消息通知
```

- **引擎**：ProcessDefinition / ProcessInstance / Task、BPMN 网关、ProcessMigration
- **业务壳**：`FlowBasicData`（主单）+ `FlowTaskInfo`（任务镜像）+ 规则/附件/邮件/知会等表
- **扩展**：`FlowLifeCycleService` SPI，新流程 ≈ BPMN + ProcessKey + LifeCycle 实现

### 3.3 主单状态机（FlowStatus）

| 状态 | 含义 | 可办 |
|------|------|------|
| Draft | 草稿箱 | 否 |
| Auditing | 审批中 | 是 |
| Rejected | 审批驳回 | 是 |
| Archived | 已归档 | 否 |
| Canceled | 被终止 | 否 |

在途版本升级仅允许 **Auditing / Rejected**。

### 3.4 核心能力矩阵

| 能力 | 关键类 |
|------|--------|
| 提交 | FlowSubmitService |
| 审批 / 批量异步 | FlowAuditService |
| 取回（多场景 Command） | FlowTakeBackService |
| 终止 / 转办 / 改签 | FlowStopService / FlowChangeAssigneeService / FlowChangeStepService |
| 图渲染 + 热升级 | FlowChartService#refreshChart |
| 业务扩展 | `*LifeCycleService` × ~30 |
| 部署 | FlowDeployService |
| 自动审批 | FlowAutoAuditJob + Handler 策略 |

---

## 四、工程实践亮点（面试可讲）

1. **主单级互斥锁统一入口**  
   `FlowProcessLockKeyHelper.getProcessLockKey(flowBasicId)`；写路径多用事务结束后释放；审批侧 setNx 租约锁，防双审。

2. **在途流程定义热升级**  
   `refreshChart`：validateMigration → migrate → 回写主数据；监控手工 + `FlowProcessVersionUpgradeJob` 批量。

3. **生命周期 SPI 隔离业务**  
   通用钩子 + 业务钩子责任链；业务放最后兜底；新流程少改引擎层。

4. **引擎能力裁剪**  
   `databaseSchemaUpdate=false`、关闭引擎 AsyncExecutor；运维异步交给 XXL-JOB / 业务线程池。

5. **自动审批可扩展**  
   Job + Handler；`canBeAutoAudit` 内置同人免重复审、会签、时间窗等规则。

6. **取回/改签多场景 Command**  
   会签 ↔ UserTask 等分支用 Factory 选择 Command，而非硬编码一条路径。

---

## 五、包结构速览

```
flowable/src/main/java/com/bigo/oa/pro/flow/
  controller/          # HTTP 入口（用户侧、监控、对外 API）
  process/             # 流程操作核心
    submit | audit | takeBack | stop | changeAssignee | changeStep
    chart | deploy | draft | copy | lock | listener | behavior | ...
  callback/workflow/   # ~30 个业务 LifeCycle
  service/             # 主数据、任务、规则、列表等
  job/                 # XXL-JOB 部署、自动审批、版本升级、补偿
  config/              # EngineConfig 引擎定制
  help/                # ProcessEngineHelper、LifeCycle 装配等
```

资源：

- `resources/flow/*.bpmn20.xml`：BPMN 定义
- `resources/mapper/*.xml`：联表 SQL
- `resources/langs/*`：i18n

---

## 六、写法注意

- 简历少堆类名，突出「解耦扩展、并发控制、热升级、自动审批」等结果导向表述。
- 面试再展开：SPI 装配、锁粒度、Migration 失败处理、会签取回 Command、异步审批与占用清理。
- 规模数字来自仓库静态统计，面试可用「数十类流程、近三百个模块类」等近似表述。
