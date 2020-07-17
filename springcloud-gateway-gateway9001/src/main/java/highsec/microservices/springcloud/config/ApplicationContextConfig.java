package highsec.microservices.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName : ApplicationContextConfig
 * @Description : RestTemplate远程调用的配置类
 * @Modified_by :
 * @Version : 1.0
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
