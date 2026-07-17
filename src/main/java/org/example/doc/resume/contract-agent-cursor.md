基于当前仓库能力整理如下，可直接贴进简历（Markdown 正文，未落盘文件）。

---

# 项目经历 · Joyy OA AI Gateway

**项目简介**  
面向企业 OA 的 AI 网关服务：统一接入多模型 LLM，支撑合同智能解析、敏感信息可逆脱敏、企微 Agent 对话与 OA 流程打通，将「文件上传 → AI 抽取 → 业务回填」沉淀为可观测、可扩展的后端能力。

**技术栈**  
JDK 17 / Spring Boot 3.5 / Spring Cloud / Spring AI 1.1 / Spring AI Alibaba（ReactAgent）/ OpenFeign / Redis Sentinel / Redisson / JWT / Micrometer Prometheus / SSE / Maven

---

## 工作职责与亮点（中高级表述）

1. **多模型 AI 网关架构**  
   基于 Spring AI 设计多模型 `ChatClient` 注册与路由（DeepSeek / Qwen，普通与 thinking 模式），经 LiteLLM 统一出口；按业务流程动态加载 Prompt，支持模型热切换与合同结构化抽取，降低业务侧对单一模型的耦合。

2. **高时延链路异步化与并行优化**  
   设计合同解析异步任务体系：线程池 + Redis 任务状态机（TTL 管理）+ MDC/用户上下文透传；LLM 字段抽取与 OA 分片上传通过 `CompletableFuture` 并行执行，缩短端到端时延；线程池采用有界队列与 `CallerRunsPolicy` 实现背压，避免任务雪崩。

3. **合规向可逆脱敏流水线**  
   自研词典 + 正则双通道脱敏（人名/公司/银行卡/手机等 → `{TYPE}_{NNN}`），LLM 仅消费掩码文本，解析结果再还原并映射 OA 代码项；在满足数据合规的同时保证业务字段可回填，形成「脱敏 → 推理 → 还原」闭环。

4. **企微 Agent + OA 工作流集成**  
   基于 ReactAgent + Skills/Tools 构建企微合同助手：SSE 流式交互、文件 AES 解密、脱敏缓存、预审与发起流程；与 OA 工作台通过任务 ID 跳转打通，支持长任务「先响应后回调」，提升交互体验与流程闭环能力。

5. **服务治理与缓存/锁设计**  
   OpenFeign 对接 OA，封装 OAuth2 client_credentials（HMAC）与 Token Redis 缓存；代码项采用「逻辑过期 + Redisson 分布式锁 + 异步单飞刷新」，热路径少打下游；JWT 拦截链 + TraceId 全链路日志，接口统一响应与全局异常收敛。

6. **可观测与效果评测闭环**  
   接入 Actuator / Prometheus，补充 LLM、OA、分布式锁健康检查与 Chat Observation 用户维度标签；建设合同核心字段离线评测能力，支撑模型选型与效果回归，形成「上线能力 + 效果度量」双轨交付。

---

## 一句话项目定位（可选放项目标题下）

> 负责企业级 AI Gateway 核心设计与落地，打通 LLM、脱敏合规、异步任务与 OA/企微集成，支撑合同智能解析与 Agent 流程自动化。

---

## 精简版（简历空间紧张时用 4 条）

- 基于 Spring Boot 3.5 + Spring AI 搭建多模型 AI 网关，支持 DeepSeek/Qwen 路由与按流程 Prompt 切换
- 设计异步合同解析流水线，并行 LLM 抽取与 OA 上传，Redis 任务状态 + 上下文透传保障可追踪
- 实现可逆脱敏管线与代码项映射，保障 LLM 侧合规与 OA 业务回填
- 落地企微 ReactAgent（SSE/Tools/Skills）及 Feign OAuth、逻辑过期缓存、Prometheus 可观测与离线评测

---

如需按你们内部职级口径再压成「3 条冲击版」或改成英文简历版本，可以说一下目标岗位（偏基础架构 / 偏业务中台 / 偏 AI 应用）。



按 **AI 应用方向** 重写如下，突出模型编排、Agent、Prompt、脱敏合规与效果评测，弱化纯基础设施表述。

---

# 项目经历 · Joyy OA 合同智能解析 / AI Gateway

**项目简介**  
面向企业 OA 的合同 AI 应用服务：接入多模型 LLM，完成合同结构化抽取、敏感信息脱敏推理、企微 Agent 预审与流程发起，将「合同文件 → AI 理解 → 业务回填」做成可落地的应用能力。

**技术栈**  
Spring Boot 3.5 / Spring AI 1.1 / Spring AI Alibaba ReactAgent / LiteLLM（DeepSeek、Qwen）/ Prompt 工程 / SSE 流式 / Redis / OpenFeign / JWT

---

## 工作职责与亮点（AI 应用向）

1. **多模型合同结构化抽取**  
   基于 Spring AI 搭建合同解析应用层：按业务流加载专用 Prompt，统一输出结构化 JSON；支持 DeepSeek / Qwen 及 thinking 模式切换，清洗模型包装内容并落库/回填 OA 字段，支撑合同关键信息自动识别。

2. **Agent 化合同助手（企微场景）**  
   基于 ReactAgent + Skills/Tools 落地企微合同助手：SSE 流式对话、读脱敏缓存、法务/财务双维度预审、一键发起 OA 流程；长任务先反馈后回调，把「对话式 AI」接到真实审批链路。

3. **面向 LLM 的脱敏推理闭环**  
   设计「词典 + 正则」可逆脱敏：人名/公司/银行卡等替换为 `{TYPE}_{NNN}`，模型只见掩码文本，抽取后再还原并映射 OA 代码项；在合规前提下保证抽取可用、字段可回填。

4. **Prompt / 流程差异化与效果评测**  
   按合同流程类型拆分 Prompt 与字段映射策略；建设核心字段离线评测（枚举/日期/金额等），支撑模型选型、Prompt 迭代与回归，形成「上线能力 + 效果度量」。

5. **应用侧工程化保障**  
   合同解析异步化（任务状态可轮询），LLM 抽取与文件上传并行缩短等待；打通 OA Feign 与企微 webhook，TraceId + Token 观测贯通调用链，保证 AI 能力可接入、可追踪、可运维。

---

## 精简版（4 条，简历首选）

- 基于 Spring AI 落地合同智能解析：多模型路由（DeepSeek/Qwen）+ 流程级 Prompt，输出结构化字段并回填 OA
- 构建企微 ReactAgent 合同助手（SSE / Skills / Tools），打通预审对话与发起审批流程
- 设计可逆脱敏推理链路，LLM 仅处理掩码文本，结果还原后映射业务代码项，兼顾合规与可用
- 建立合同字段离线评测与 Prompt/模型迭代闭环，支撑效果回归与选型

---

## 一句话定位

> 负责企业合同 AI 应用落地：多模型结构化抽取、脱敏合规推理、企微 Agent 预审与 OA 流程闭环，并建设效果评测能力支撑持续优化。

---

若还要再冲一版「算法/应用混合岗」口径（少写 Spring，多写 Agent/评测/Prompt），可以说一下目标公司类型（大厂应用岗 / 中厂业务 AI / 创业公司）。