package highsec.microservices.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import highsec.microservices.springcloud.entity.CommonResult;
import highsec.microservices.springcloud.entity.DataInfo;
import highsec.microservices.springcloud.service.DataInfoFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName : FeignClientController
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
@RestController
@Slf4j
public class FeignClientController {

    @Resource
    private DataInfoFeignService dataInfoFeignService;

    @PostMapping(value = "/feign/dataInfo/create")
    public CommonResult create(@RequestBody DataInfo dataInfo){
        return dataInfoFeignService.create(dataInfo);
    }

    //设置超时峰值为1.5秒和处理超时的方法
    @HystrixCommand(fallbackMethod = "getDataInfoById_Fallback" ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" , value = "1500")
    })
    @GetMapping(value = "/feign/dataInfo/get/{id}")
    public CommonResult<DataInfo> getDataInfoById(@PathVariable("id") Long id){
        return dataInfoFeignService.getDataInfoById(id);
    }

    //超时处理方法，Hystrix会使用自己的线程池
    public CommonResult<DataInfo> getDataInfoById_Fallback(Long id){

        return new CommonResult(408,
                "微服务消费者80自己运行出错或超时，请检查自己，o(╥﹏╥)o");

    }

    @DeleteMapping(value = "/feign/dataInfo/delete/{id}")
    public CommonResult deleteDataInfoById(@PathVariable("id") Long id){
        return dataInfoFeignService.deleteDataInfoById(id);
    }

    @PutMapping(value = "/feign/dataInfo/put")
    public CommonResult updateDataInfo(@RequestBody DataInfo dataInfo){
        return dataInfoFeignService.updateDataInfo(dataInfo);
    }
}
