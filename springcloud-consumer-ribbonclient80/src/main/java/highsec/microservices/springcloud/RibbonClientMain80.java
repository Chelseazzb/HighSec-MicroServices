package highsec.microservices.springcloud;

import highsec.microservices.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName : FeignClientMain80
 * @Description : Feign客户端80主启动类
 * @Modified_by :
 * @Version : 1.0
 **/
@SpringBootApplication
@EnableEurekaClient //激活Eureka Client
@RibbonClient(name = "CLOUD-DATAINFO-SERVICE",configuration = MyselfRule.class)
public class RibbonClientMain80 {

    public static void main(String[] args) {
        SpringApplication.run(RibbonClientMain80.class, args);
    }
}
