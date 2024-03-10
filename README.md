技术选型:
用户层: node.js, vue.js, elementUI, 微信小程序, apache echarts。
网关层: Nginx。
应用层: Spring Boot, Spring MVC, Spring Task, httpclient, Spring Cache, JWT, 阿里云OS, Swagger, POI, WebSocket。
数据层: Mysql, Redis, mybatis, pageHelper, spring data redis。
外加其它工具。

sky-take-out:
maven父工程，统一管理依赖版本。
sky-common:
子模块，存放公共类，例如：工具类、常量类、异常类等。
sky-pojo:
子模块，存放实体类、VO、DTO等。
sky-server:
子模块，后端服务，存放配置文件、Controller、Service、Mapper等。
sky-related-resources:
存放整个项目所需要的相关文件。

