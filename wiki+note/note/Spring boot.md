### Spring boot   
Spring Boot:旨在简化创建产品级的 Spring 应用和服务，简化了配置文件，使用嵌入式web服务器
Spring Boot有四大神器，分别是auto-configuration、starters、cli、actuator，本文主要讲actuator。actuator是spring boot提供的对应用系统的自省和监控的集成功能，可以对应用系统进行配置查看、相关功能统计等。
启动项目另外两种方式：

Spring Boot，看名字就知道是Spring的引导，就是用于启动Spring的，使得Spring的学习和使用变得快速无痛。不仅适合替换原有的工程结构，更适合微服务开发。Spring Cloud基于Spring Boot，为微服务体系开发中的架构问题，提供了一整套的解决方案——服务注册与发现，服务消费，服务保护与熔断，网关，分布式调用追踪，分布式配置管理等。学过Spring的都知道，Spring开发有非常头疼的三点: 以启动一个带Hibernate的Spring MVC为例。1. 依赖太多了，而且要注意版本兼容。这个应用，要添加10-20个依赖，Spring相关的包10多个，然后是Hibernate包，Spring与Hibernate整合包，日志包，json包一堆，而且要注意版本兼容性。2. 配置太多了，要配置注解驱动，要配置数据库连接池，要配置Hibernate，要配置事务管理器，要配置Spring MVC的资源映射，要在web.xml中配置启动Spring和Spring MVC。。等3.部署和运行麻烦。要部署到tomcat里面。不能直接用java命令运行。太多重复和大家都一样的配置了。
Spring Boot的哲学就是约定大于配置。既然很多东西都是一样的，为什么还要去配置。1. 通过starter和依赖管理解决依赖问题。2. 通过自动配置，解决配置复杂问题。3. 通过内嵌web容器，由应用启动tomcat，而不是tomcat启动应用，来解决部署运行问题。Spring Cloud体系就比较复杂了。基本可以理解为通过Spring Boot的三大魔法，将各种组件整合在一起，非常简单易用。

1. mvn spring-boot:run
2. java -jar demoXX.jar


1. 不一定有maven构建
2. 服务发现暴露出server的地址
3. client注册在服务，服务名字
4. 打包为jar包，每个服务独立打包独立部署
5. 主要是为了服务治理，当一个项目变的很复杂，
6. 一个技术的出现为了解决什么问题出现的

注意:
 @GetMapping("/a/{id}")
    public String speak(@PathVariable("id") Integer id) {
        return String.valueOf(id);
    }

  不是@PathParam

### mysql   
原来Linux下的MySQL默认是区分表名大小写的，通过如下设置，可以让MySQL不区分表名大小写：


http://localhost:8080/validAddGirl?cupSize=F&age=122

### search   
搜索引擎选择： Elasticsearch与Solr
https://www.cnblogs.com/chowmin/articles/4629220.html

### java   
java.date.util 比较日期date.before(); after();

### maven   
  maven、ant、gradle   管理和构建项目
没有使用maven前，需要在各大官网上下载项目所需要的jar包，引入到自己的项目中,可能会有冲突，需要的不需要的，增加了对项目管理的难度
基于项目对象模型（POM），可以通过一小段描述信息来管理项目的构建。
maven.apache.org
* maven 目录结构：bin；boot；conf...
maven 项目目录结构：
src
   -main
	-java
	     -package
   -test
	-java
	     -package
   -source
pom.xml
-----------------------
maven 常用构建命令
mvn compile 编译源项目 编译的过程中，用到其他包首先pom.xml，中仓库中有会加入本项目的classpath中，没有去远程maven仓库中查找下载并且放到本地仓库
mvn test 生成的测试报告   
		生成了tartget目录  
			-class   
			-surefire-repports生成的测试报告  
			-...  
mvn package 打包项目  
mvn clean  删除target目录
mvn install 把jar文件发布到本地仓库中

mvn archetype:generate 自动创建maven项目的骨架,按照提示创建

构件 坐标
远程仓库：https://repo.maven.apache.org/maven2/

中央仓库： http://search.maven.org/

镜像仓库： 国内提供的maven仓库
	修改maven安装目录/conf/settings.xml

```  

	<mirror>
      <id>maven.net.cn</id>
      <mirrorOf>central</mirrorOf>
      <name>central mirror in china</name>
      <url>http://maven.net.cn/content/groups/public</url>
    </mirror>

```
更改本地仓库默认位置
<localRepository>J：/mook/repo</localRepository>
settings.xml 复制一份到新建的repo
mvn clean compile
eclipse安装maven看教程
完整项目的构建过程(生命周期)
清理、编译、测试、打包、集成测试、验证、部署
一可以将源代码打包，需要pox.xml定义
一个maven项目不一定是完整的项目，体现了模块化概念


### thymeleaf模板
jsp当界面渲染,因为前后端分离不是很好,反而模板引擎用的比较多,thymeleaf最大的优势后缀为html,就是只需要浏览器就可以展现页面了,还有就是thymeleaf可以很好的和spring集成.
1. maven中直接引入
```
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
```
可以查看依赖关系,发现spring-boot-starter-thymeleaf下面已经包括了spring-boot-starter-web,所以可以把spring-boot-starter-web的依赖去掉.


### Angular 
为什么使用mvc
1. 代码规模越来越大，切分指责是必须的，
2. 为了复用代码，很多逻辑是一样的
3. 为了后期维护方便， 修改一块功能不至于影响其他的模块
MVC是手段，终极目标是模块化和复用。
前端mvc困难
1. 操作dom，需要整个页面完全加在完
2. js出现相互依赖，需要自己解决
3. js的原型继承
为什么要使用路由
1. ajax不会产生history记录
2. 无法通过指定的url进入应用的是指定的页面,（保存书签，链接分享）
3. SEO实现困难，搜索引擎的优化


### Spring Cloud  
1. Spring Cloud是一个基于Spring Boot实现的云应用开发工具，它为基于JVM的云应用开发中的配置管理、服务发现、断路器、智能路由、微代理、控制总线、全局锁、决策竞选、分布式会话和集群状态管理等操作提供了一种简单的开发方式。

Spring Cloud包含了多个子项目（针对分布式系统中涉及的多个不同开源产品），比如：Spring Cloud Config、Spring Cloud Netflix、Spring Cloud CloudFoundry、Spring Cloud AWS、Spring Cloud Security、Spring Cloud Commons、Spring Cloud Zookeeper、Spring Cloud CLI等项目。

2. 微服务架构
"微服务架构”在这几年非常的火热，以至于关于微服务架构相关的产品社区也变得越来越活跃（比如：netflix、dubbo），Spring Cloud也因Spring社区的强大知名度和影响力也被广大架构师与开发者备受关注。

那么什么是“微服务架构”呢？简单的说，微服务架构就是将一个完整的应用从数据存储开始垂直拆分成多个不同的服务，每个服务都能独立部署、独立维护、独立扩展，服务与服务间通过诸如RESTful API的方式互相调用。

对于“微服务架构”，大家在互联网可以搜索到很多相关的介绍和研究文章来进行学习和了解。也可以阅读始祖Martin Fowler的《Microservices》，本文不做更多的介绍和描述。

#### 服务注册与发现
在简单介绍了Spring Cloud和微服务架构之后，下面回归本文的主旨内容，如何使用Spring Cloud搭建服务注册与发现模块。

这里我们会用到Spring Cloud Netflix，该项目是Spring Cloud的子项目之一，主要内容是对Netflix公司一系列开源产品的包装，它为Spring Boot应用提供了自配置的Netflix OSS整合。通过一些简单的注解，开发者就可以快速的在应用中配置一下常用模块并构建庞大的分布式系统。它主要提供的模块包括：服务发现（Eureka），断路器（Hystrix），智能路有（Zuul），客户端负载均衡（Ribbon）等。

所以，我们这里的核心内容就是服务发现模块：Eureka。下面我们动手来做一些尝试。

##### 服务之间的通信
Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign。在这一篇文章首先讲解下基于
1. ribbon+rest。
ribbon是一个负载均衡客户端，可以很好的控制htt和tcp的一些行为。Feign默认集成了ribbon。

2. Feign简介

Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。

#### 断路器
在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。

为了解决这个问题，业界提出了断路器模型。

启动：service-ribbon 工程，当我们访问http://localhost:8764/hi?name=forezp,浏览器显示：
hi forezp,i am from port:8762

此时关闭 service-hi 工程，当我们再访问http://localhost:8764/hi?name=forezp，浏览器会显示：
hi ,forezp,orry,error!

这就说明当 service-hi 工程不可用的时候，service-ribbon调用 service-hi的API接口时，会执行快速失败，直接返回一组字符串，而不是等待响应超时，这很好的控制了容器的线程阻塞。

spring cloud子项目包括：
Spring Cloud Config：配置管理开发工具包，可以让你把配置放到远程服务器，目前支持本地存储、Git以及Subversion。
Spring Cloud Bus：事件、消息总线，用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署。
Spring Cloud Netflix：针对多种Netflix组件提供的开发工具包，其中包括Eureka、Hystrix、Zuul、Archaius等。
Netflix Eureka：云端负载均衡，一个基于 REST 的服务，用于定位服务，以实现云端的负载均衡和中间层服务器的故障转移。
Netflix Hystrix：容错管理工具，旨在通过控制服务和第三方库的节点,从而对延迟和故障提供更强大的容错能力。
Netflix Zuul：边缘服务工具，是提供动态路由，监控，弹性，安全等的边缘服务。
Netflix Archaius：配置管理API，包含一系列配置管理API，提供动态类型化属性、线程安全配置操作、轮询框架、回调机制等功能。
Spring Cloud for Cloud Foundry：通过Oauth2协议绑定服务到CloudFoundry，CloudFoundry是VMware推出的开源PaaS云平台。
Spring Cloud Sleuth：日志收集工具包，封装了Dapper,Zipkin和HTrace操作。
Spring Cloud Data Flow：大数据操作工具，通过命令行方式操作数据流。
Spring Cloud Security：安全工具包，为你的应用程序添加安全控制，主要是指OAuth2。
Spring Cloud Consul：封装了Consul操作，consul是一个服务发现与配置工具，与Docker容器可以无缝集成。
Spring Cloud Zookeeper：操作Zookeeper的工具包，用于使用zookeeper方式的服务注册和发现。
Spring Cloud Stream：数据流操作开发包，封装了与Redis,Rabbit、Kafka等发送接收消息。
Spring Cloud CLI：基于 Spring Boot CLI，可以让你以命令行方式快速建立云组件。



server.port=8989

eureka.instance.hostname=localhost
eureka.client.registerWithEureka=false
eureka.client.fetchRegistry=false
eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/


emergency! eureka may be incorrectly claiming instances are up when they're not. renewals are lesser than threshold and hence the instances are not being expired just to


<dependency>
  <groupId>org.apache.poi</groupId>
  <artifactId>poi-ooxml</artifactId>
  <version>3.10-FINAL</version>
</dependency>
