package highsec.microservices.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @ClassName : HystrixDashboardMain6001
 * @Description : Hystrix DashBoard主启动类
 * @Modified_by :
 * @Version : 1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard //激活Dashboard
public class HystrixDashboardMain6001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain6001.class, args);
    }
}
