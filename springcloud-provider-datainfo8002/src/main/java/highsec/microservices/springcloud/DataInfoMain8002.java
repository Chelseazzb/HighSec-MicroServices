package highsec.microservices.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

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
public class DataInfoMain8002 {

    @Bean
    public ServletRegistrationBean getServlet(){ //此配置是为了服务监控而配置，与服务容错本身无关，SpringCloud升级后的坑
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        //ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"，只要在自己的项目里配置下面的servlet就可以了
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricStreamServlet");
        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(DataInfoMain8002.class, args);
    }
}
