package highsec.microservices.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : FeignClientMain80
 * @Description : Feign客户端-微服务消费者
 * @Modified_by :
 * @Version : 1.0
 **/
@SpringBootApplication
@EnableFeignClients //激活并开启Feign
@EnableHystrix //激活Hystrix
public class FeignClientMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignClientMain80.class, args);
    }
}
