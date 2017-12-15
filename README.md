# ssm
springmvc+Spring+Mybatis 学习参考项目

## 目录结构介绍

### com
>   anno  自定义注解
>   aop   切入点
>   dao   数据访问层
>   dto   数据实体层
>   exception   全局异常定义
>   service     业务层

#   resources
>   customize-mapper.mysql  mybatis数据库脚本文件
>   dao-mybaties-mapper     mybatis配置文件
>   dtms-spring             应用层配置dao、service
>   dtms-springmvc          SpringMvC配置文件
>   message                 国际化文件
>   jdbc.properties         数据库信息配置
>   log4j.properties        日志文件


# test  测试用例

>  transactional        事物测试

# resources
> transactional         事物测试配置文件


# 案例demo
## 事物测试

编码文件地址 : test/java/transactional/TransactionalTest

配置文件地址 : test/resources/transactional