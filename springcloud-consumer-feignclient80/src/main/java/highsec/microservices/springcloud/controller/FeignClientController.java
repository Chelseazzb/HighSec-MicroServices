package highsec.microservices.springcloud.controller;

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

    @GetMapping(value = "/feign/dataInfo/get/{id}")
    public CommonResult<DataInfo> getDataInfoById(@PathVariable("id") Long id){
        return dataInfoFeignService.getDataInfoById(id);
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
