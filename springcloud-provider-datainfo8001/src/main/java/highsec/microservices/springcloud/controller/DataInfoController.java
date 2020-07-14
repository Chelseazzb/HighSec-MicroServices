package highsec.microservices.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import highsec.microservices.springcloud.entity.CommonResult;
import highsec.microservices.springcloud.entity.DataInfo;
import highsec.microservices.springcloud.service.DataInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName : DataInfoController
 * @Description : 控制层REST接口
 * @Modified_by :
 * @Version : 1.0
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_Fallback_Method")
public class DataInfoController {

    @Resource
    private DataInfoService dataInfoService;

    @Value("${server.port}")
    private String serverPort; //打印服务的端口号

    @Resource
    private DiscoveryClient discoveryClient;

    @HystrixCommand //服务降级默认使用全局方法
    @PostMapping(value = "/dataInfo/create")
    public CommonResult create(@RequestBody DataInfo dataInfo){  //插入一条业务数据

        int result = dataInfoService.createDataInfo(dataInfo);
        log.info("********插入Payment结果：" + result + "********"); //打印日志
        if (result > 0){
            return new CommonResult(200 , "使用端口：" + serverPort + "的服务插入DataInfo数据成功", result);
        }else {
            return new CommonResult(444, "使用端口：" + serverPort + "的服务插入DataInfo失败", null);
        }
    }

    //设置超时峰值为3秒和处理超时的方法
    @HystrixCommand(fallbackMethod = "getDataInfoById_Fallback" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" , value = "3000")
    })
    @GetMapping(value = "/dataInfo/get/{id}")
    public CommonResult<DataInfo> getDataInfoById(@PathVariable("id") Long id){  //通过id查询业务数据

        //暂停二秒钟
//        try {
//            TimeUnit.SECONDS.sleep((2));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //int age = 10 / 0; //计算错误也会触发降级
        DataInfo result = dataInfoService.getDataInfoById(id);
        log.info("********查询DataInfo结果：" + result + "*******"); //打印日志
        if (result != null){
            return new CommonResult(200 , "使用端口：" + serverPort + "的服务查询DataInfo成功，id为：" + id, result);
        }else {
            return new CommonResult(444, "使用端口：" + serverPort + "的服务查询DataInfo没有记录，id为：" + id, null);
        }
    }

    //超时处理方法，Hystrix会使用自己的线程池
    public CommonResult<DataInfo> getDataInfoById_Fallback(Long id){

        return new CommonResult(500,"线程池：" + Thread.currentThread().getName() +
                ", 8002系统繁忙或者运行报错，请稍后再试, id: " + id + "\t" + "o(╥﹏╥)o");

    }

    @HystrixCommand //服务降级默认使用全局方法
    @DeleteMapping(value = "/dataInfo/delete/{id}")
    public CommonResult deleteDataInfoById(@PathVariable("id") Long id){ //通过id删除业务数据
        int result = dataInfoService.deleteDataInfoById(id);
        log.info("********删除DataInfo结果：" + result + "********"); //打印日志
        if (result > 0){
            return new CommonResult(200 , "使用端口：" + serverPort + "的服务删除DataInfo数据成功", result);
        }else {
            return new CommonResult(444, "使用端口：" + serverPort + "的服务删除DataInfo失败", null);
        }
    }

    @HystrixCommand //服务降级默认使用全局方法
    @PutMapping(value = "/dataInfo/put")
    public CommonResult updateDataInfo(@RequestBody DataInfo dataInfo){ //更新业务数据
        int result = dataInfoService.updateDataInfo(dataInfo);
        log.info("********更新DataInfo结果：" + result + "********"); //打印日志
        if (result > 0){
            return new CommonResult(200 , "使用端口：" + serverPort + "的服务更新DataInfo数据成功", result);
        }else {
            return new CommonResult(444, "使用端口：" + serverPort + "的服务更新DataInfo失败", null);
        }
    }

    @HystrixCommand //服务降级默认使用全局方法
    @GetMapping("/dataInfo/lb")
    public String getPaymentLB(){ //获得服务的端口号
        return serverPort;
    }

    @HystrixCommand //服务降级默认使用全局方法
    @GetMapping("/dataInfo/discovery")
    public Object discovery(){ //查看服务的实例列表
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("******element: " + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-DATAINFO-SERVICE");
        for ( ServiceInstance instance : instances ) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @HystrixCommand //服务降级默认使用全局方法
    @GetMapping("/health")
    @ResponseBody
    public String health(){  //Gateway对微服务进行健康检查
        return "ok";
    }


    //下面是全局fallback方法
    public CommonResult<DataInfo> global_Fallback_Method(){
        return new CommonResult(503,"目前微服务不可用，请稍后再试，o(╥﹏╥)o");
    }
}
