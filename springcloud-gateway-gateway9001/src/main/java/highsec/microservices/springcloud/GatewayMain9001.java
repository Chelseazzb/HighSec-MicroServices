package highsec.microservices.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : GatewayMain9001
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //激活并开启Feign
public class GatewayMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9001.class, args);
    }
}
