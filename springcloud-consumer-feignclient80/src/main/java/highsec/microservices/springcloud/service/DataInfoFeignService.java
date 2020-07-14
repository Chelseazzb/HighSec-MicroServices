package highsec.microservices.springcloud.service;

import highsec.microservices.springcloud.entity.CommonResult;
import highsec.microservices.springcloud.entity.DataInfo;
import highsec.microservices.springcloud.service.fallback.DataInfoFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : DataInfoFeignService
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
@Component
@FeignClient(value = "CLOUD-DATAINFO-SERVICE",fallback = DataInfoFallbackService.class) //将fallback实现类与Feign接口绑定
public interface DataInfoFeignService { //将DataInfoController中的方法头拷贝过来

    @PostMapping(value = "/dataInfo/create")
    public CommonResult create(@RequestBody DataInfo dataInfo);

    @GetMapping(value = "/dataInfo/get/{id}")
    public CommonResult<DataInfo> getDataInfoById(@PathVariable("id") Long id);

    @DeleteMapping(value = "/dataInfo/delete/{id}")
    public CommonResult deleteDataInfoById(@PathVariable("id") Long id);

    @PutMapping(value = "/dataInfo/put")
    public CommonResult updateDataInfo(@RequestBody DataInfo dataInfo);


}
