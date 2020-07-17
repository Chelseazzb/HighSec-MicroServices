package highsec.microservices.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName : EurekaMain7001
 * @Description : Eureka的服务器实例1
 * @Modified_by :
 * @Version : 1.0
 **/
@SpringBootApplication
@EnableEurekaServer //代表是Eureka Server
public class EurekaMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
