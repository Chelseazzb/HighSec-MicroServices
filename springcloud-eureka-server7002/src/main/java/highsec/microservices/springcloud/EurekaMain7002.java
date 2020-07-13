package highsec.microservices.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName : EurekaMain7002
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
@SpringBootApplication
@EnableEurekaServer //代表是Eureka Server
public class EurekaMain7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
