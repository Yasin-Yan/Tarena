### 业务说明
实体分为图书和预约行为，主要介绍预约流程，预约时接收图书编号和学生编号，根据图书编号更新图书数量，使其减少一本，更新失败返回库存不足信息；
更新成功则将学生编号，图书编号存入预约表，插入失败则返回重复预约信息；插入成功则返回预约成功信息。

### 编码规范
+ 将spring配置文件分为spring-dao、spring-service、spring-web,spring-dao整合spring和mybatis,spring-service负责组件扫描、事务管理，spring-web实现映射
相关组件和视图解析

+ 项目分为enums、exceptions、entity、dao、dto、service、service.impl、web，enums枚举类储存状态信息，exceptions定制异常，dto数据传输对象，service服务接口，
service.impl实现服务接口

### 知识点


