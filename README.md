# HighSec-MicroServices
### 高安全性微服务引擎平台：

本项目使用了Spring Boot + Spring Cloud技术从零搭建，包含的技术栈如下：

+ Java 8
+ Maven 3.5.2
+ Spring Boot 2.2.2
+ Spring Cloud 2.1.0
+ Mysql 5.7.27
+ Druid-阿里数据源管理
+ Eureka-微服务发现注册中心
+ Ribbon-客户端负载均衡
+ OpenFeign-Rest接口客户端远程调用
+ Gateway-微服务网关
+ Hystrix-微服务容错降级



#### 本项目包括的功能组件如下：

微服务发现注册中心集群：端口号为7001和7002

微服务提供者集群：端口号为8001和8002

微服务网关：端口号为9001

微服务调用者：Ribbon客户端80、Feign客户端80

微服务监控：端口号为6001



#### 本项目的架构图如下：





#### 本项目的部署方式如下：

首先启动Eureka集群7001和7002，再启动微服务提供者集群8001和8002，然后启动Gateway9001和HystrixDashboard6001，最后任意启动一个80的微服务消费者。

数据库的yaml文件需要修改成你自己的，在8001和8002的java/main/resources/application.yml里面。

数据库文件在：java/main/resources/sql文件夹下面。



#### 本项目的服务触发方式：

微服务发现注册中心地址：http://eureka7002.com:7002/，http://eureka7001.com:7001/

##### 使用其中一个微服务提供者：

业务数据录入：http://localhost:8001/dataInfo/create，POST请求

```json
{
	"dataName":"file3",
	"dataType": "文件",
	"dataOwner":"中国",
	"dataLocation":"E:/HighSec-MicroServices/doc",
	"dataSize":"12M",
    "uploadTime":1594555074825,
    "dataLevel":"公开",
    "dataDescription":"这是一个遥感文件数据"
}
```

业务数据修改：http://localhost:8001/dataInfo/put，PUT请求

```json
{
	"id":3,
	"dataName":"file3",
	"dataType": "文件",
	"dataOwner":"北京",
	"dataLocation":"D:/HighSec-MicroServices/doc",
	"dataSize":"12M",
    "dataLevel":"秘密",
    "dataDescription":"这是一个遥感文件数据"
}
```

业务数据查询：http://localhost:8001/dataInfo/get/3，GET请求

业务数据删除：http://localhost:8001/dataInfo/delete/3，DELETE请求



##### 使用服务网关：

业务数据录入：http://localhost:9001/dataInfo/create，POST请求

```json
{
	"dataName":"file1",
	"dataType": "图片",
	"dataOwner":"中国",
	"dataLocation":"E:/HighSec-MicroServices/image",
	"dataSize":"5MB",
    "uploadTime":1594714327353,
    "dataLevel":"秘密",
    "dataDescription":"这是一个遥感数据"
}
```

业务数据修改：http://localhost:9001/dataInfo/put，PUT请求

```json
{
	"id":1,
	"dataName":"file1",
	"dataType": "图片",
	"dataOwner":"中国",
	"dataLocation":"D:/HighSec-MicroServices/image",
	"dataSize":"5M",
    "dataLevel":"公开",
    "dataDescription":"这是一个遥感图片数据"
}
```

业务数据查询：http://localhost:9001/dataInfo/get/1，GET请求

业务数据删除：http://localhost:9001/dataInfo/delete/1，DELETE请求



##### 使用80客户端：

业务数据录入：http://localhost/consumer/dataInfo/create

```json
{
	"dataName":"file2",
	"dataType": "视频",
	"dataOwner":"中国",
	"dataLocation":"E:/HighSec-MicroServices/video",
	"dataSize":"50M",
    "uploadTime":1594604028829,
    "dataLevel":"公开",
    "dataDescription":"这是一个遥感视频数据"
}
```

业务数据修改：http://localhost/consumer/dataInfo/put，PUT请求

```json
{
	"id":2,
	"dataName":"file2",
	"dataType": "视频",
	"dataOwner":"北京",
	"dataLocation":"E:/HighSec-MicroServices/video",
	"dataSize":"50M",
    "dataLevel":"秘密",
    "dataDescription":"这是一个遥感视频数据"
}
```



业务数据查询：http://localhost/consumer/dataInfo/get/2，GET请求

业务数据删除：http://localhost/consumer/dataInfo/delete/2，DELETE请求



##### 使用Hystrix Dashboard进行监控：

服务地址：http://localhost:6001/hystrix

http://localhost:8001/hystrix.stream