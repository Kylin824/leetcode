# OA 审批协同平台 · 工作流引擎模块（简历项目内容）

> 面向**中高级 Java 后端**岗位。本文档基于仓库 `flowable/` 模块源码实测梳理，所有技术点均可经代码追问佐证；量化指标中「实测」项来自仓库统计，「【待补充】」项需你按真实线上数据填写，避免造假。

---

## 一、项目概述

公司自研 OA 审批协同平台的核心——**基于 Flowable 6.7.1 深度定制的工作流引擎**。为全公司预算、合同、发票、充值、佣金、薪酬、资产、假期等 10+ 业务域提供统一的流程编排能力，沉淀 34 套 BPMN 流程模板，支撑从发起、多级审批、会签、驳回、撤回、转办、加签到终止的完整审批生命周期，并通过分布式锁、流程热升级、异步解耦等机制保障高并发下的数据一致性与系统稳定性。

**技术栈**：Java / Spring Boot、Flowable 6.7.1（BPMN 2.0）、Redisson 分布式锁、XXL-JOB、MySQL、Redis、Feign/RPC、Kafka、规则引擎（basic 模块）。

---

## 二、精简版（直接填简历项目栏，约 170 字）

负责公司 OA 审批平台核心工作流引擎的设计与开发。基于 Flowable 6.7.1 进行深度二次开发：通过自定义命令/事件监听/任务拦截器/解析器与 EL 表达式桥接规则引擎，实现可配置、可扩展的审批流；覆盖提交、多级审批、会签、驳回、撤回、转办、加签全生命周期；设计主单级 Redisson 分布式锁（事务提交后释放 + 幂等）保障高并发审批一致性；基于 ProcessMigrationService 实现在途流程定义热升级，配合 XXL-JOB 批量平滑迁移免重提；通过 Feign/事件/Kafka 与多个业务模块解耦。

---

## 三、核心职责 / 架构设计亮点

### 1. 工作流引擎深度定制（扩展点体系）
基于 `EngineConfigurationConfigurer<SpringProcessEngineConfiguration>` 统一装配，在开源引擎之上做深度增强：
- 自定义 `UserTaskListener`：监听任务创建/完成/指派，同步业务表 `FlowTaskInfo`；
- `DefaultCreateUserTaskInterceptor`：实现离职自动转办、默认审批人补全；
- `CustomDefaultActivityBehaviorFactory` / 自定义序列流解析器（扩展优先级字段）/ `AutoUpgradeParallelUserTaskBpmnParseHandler`：单节点多人审批自动升级为并行会签图；
- `FunctionExpressionResolver`（Bean 名 `fn`）：将 `${getAuditUser(...)}` 等表达式桥接规则引擎，动态算人。
- **价值**：把「流程如何跑」与「谁该审批」解耦，业务变更无需改 BPMN，改规则即可。

### 2. 流程全生命周期编排
22 个流程 Service 类覆盖 `submit / audit / takeBack / stop / changeStep(加签) / changeAssignee(转办) / draft / copy`；审批支持会签驳回自动跳过、自动审批、批量审批、同步/异步执行；撤回/转步骤通过 `TakeBackCommand` / `ChangeStepCommand` 命令模式按场景分派，经 `ManagementService.executeCommand` 执行。
- **价值**：一套引擎支撑 34 套差异化业务流程。

### 3. 高并发审批一致性（主单级分布式锁 + 幂等）⭐
- `FlowProcessLockKeyHelper.getProcessLockKey(flowBasicId)` 统一锁 key 入口；
- 底层 Redisson `RLock`：`lockAndReleaseAfterTransactionCompleted` 在 `@Transactional` 内加锁并注册 `TransactionSynchronizationAdapter.afterCompletion`，**事务真正提交后才释放**，借 watchdog 自动续期；多 key 按字典序排序后 `getMultiLock` 获取，避免死锁；
- 审批 `audit` 用 `setNx` + 唯一 UUID 值占锁，并查 `FlowAuditingRecord`（flowBasicId + taskId 唯一）做业务幂等，杜绝并发重复审批。
- **价值**：多人/多端同时操作同一单据时，零脏读、零重复审批。

### 4. 在途流程定义热升级（零重提）⭐
- `FlowChartService.refreshChart`：`@Transactional` + 主单锁 → 取最新 `ProcessDefinition`（支持 tenantId 租户维度）→ 用 Flowable `ProcessMigrationService.validateMigration()` 预检节点映射 → 通过则 `migrate()` → 回写主单 processDefinitionId/节点；预检失败给出明确提示可回退；
- `FlowProcessVersionUpgradeJob`（`@XxlJob`）：批量筛选在途单（status∈Auditing/Rejected 且有实例），逐条 `refreshChart` 升级，输出 total/success/fail。
- **价值**：流程模板迭代时，正在审批的单据无需撤回重提即可平滑迁移到新版本。

### 5. 模块解耦与异步化
流程引擎只管流程；业务回调通过 `rpc` 模块 Feign（`BudgetApi` / `OaContractApi` / `OaOrderFlowApi` 等）+ `ApplicationEventPublisher` 事件 + Kafka 监听（invoice）异步触达预算/合同/采购/发票等模块；自动审批、预算同步、发票核验等由 XXL-JOB 调度（实测 18 个 `@XxlJob`）。
- **价值**：引擎与业务正交，新增审批场景不改引擎，业务方通过 RPC/事件接入。

### 6. 自研「虚拟执行」流程图渲染
`FlowChartService` 读取流程定义、遍历 UserTask/网关并解析 `${starter}` 等表达式（**无需启动真实流程实例**），生成流程步骤与状态；`ProcessDiagramGenerator` 输出 PNG 供下载/展示。
- **价值**：流程图随单据状态实时渲染，且不占用引擎执行资源。

---

## 四、技术难点与解决方案（面试可展开）

- **难点 1：同一单据被多人/多端并发审批，导致重复通过、状态错乱。**
  方案：主单级 Redisson 锁（key 统一入口）+ 事务提交后释放（避免事务未提交就解锁造成脏读）+ `setNx` 唯一值 + 审计表幂等，三重保障；锁与事务生命周期绑定，失败自动回滚释放。

- **难点 2：流程模板升级后，大量在途审批单如何平滑迁移到新版本而不丢失进度。**
  方案：基于 Flowable `ProcessMigrationService` 做节点映射预检 + 迁移；预检不通过（如节点被删）给出明确原因、可回退不改写；配合 XXL-JOB 批量执行并上报成功/失败数。

- **难点 3：审批人规则复杂且频繁变化（按组织、金额、角色动态算人）。**
  方案：自定义 EL 表达式解析器 `fn`，把 `${getAuditUser(...)}` 桥接到规则引擎，审批人计算与 BPMN 解耦，规则变更零代码、热更新。

---

## 五、个人贡献（请按实际角色填写，避免代写不实内容）

- 我在项目中的角色：【如：核心开发 / 模块负责人 / 架构设计参与者】
- 主导 / 参与的设计：【如：分布式锁方案、流程热升级、规则引擎桥接】
- 独立交付的模块 / 需求：【如：撤回命令、并行会签自动升级、XXL-JOB 自动审批】
- 解决的线上问题：【如：某次并发重复审批事故定位与修复】

---

## 六、可量化成果（「【待补充】」项为需你按真实线上数据填写）

- BPMN 流程模板：**实测 34 套**（覆盖 10+ 业务域）【业务域数量可细化补充】
- 流程 Service 类：**实测 22 个**，覆盖全生命周期
- 定时任务：**实测 18 个 `@XxlJob`**（15 个任务类）
- 引擎版本：Flowable 6.7.1
- 【待补充】日均审批单量 / 峰值 QPS / 流程热升级累计覆盖单据数 / 并发重复审批事故归零后的稳定性指标

---

## 附：仓库实测可佐证清单（BPMN 流程模板，节选）

`budgetApplyNew`、`budgetAdjustNew`、`budgetTotalApplyNew`、`budgetAdditionNew`、`longTermBudgetApply`、`budgetBalanceChange`、`invoiceApplyNew`、`adRechargeApply`、`commissionPaymentApply`、`coinMerchantRecharge`、`virtualCurrencyPaymentNew`、`virtualAssetRepair`、`positionAdd`、`shiftChange`、`leaveCancelApply`、`itAssetConfirmation`、`anchorPolicy`、`paymentCertificateApply`、`uidDataModifyApply` 等共 34 个。
