package highsec.microservices.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName : DataInfoMain8001
 * @Description : DataInfo服务提供者主启动类
 * @Modified_by :
 * @Version : 1.0
 **/
@SpringBootApplication
@EnableEurekaClient //激活Eureka Client
@EnableDiscoveryClient //激活服务发现
@EnableCircuitBreaker //激活Hystrix的断路器
public class DataInfoMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(DataInfoMain8001.class, args);
    }
}
