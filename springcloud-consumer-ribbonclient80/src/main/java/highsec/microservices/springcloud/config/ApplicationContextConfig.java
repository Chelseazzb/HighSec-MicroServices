package highsec.microservices.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName : ApplicationContextConfig
 * @Description : RestTemplate配置类
 * @Modified_by :
 * @Version : 1.0
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //使用@LoadBalanced注解富裕RestTemplate负载均衡能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
