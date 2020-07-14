package highsec.microservices.springcloud.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import highsec.microservices.springcloud.entity.CommonResult;
import highsec.microservices.springcloud.entity.DataInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName : ConsumerController
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
@RestController
@Slf4j
public class ConsumerController {

//    public static final String DataInfo_URL = "http://localhost:8001";

    public static final String DataInfo_URL = "http://CLOUD-DATAINFO-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/dataInfo/create")
    public CommonResult<DataInfo> createDataInfo(@RequestBody DataInfo dataInfo){
        log.info("*****使用消费者进行DataInfo创建*****");
        return restTemplate.postForObject(DataInfo_URL + "/dataInfo/create", dataInfo, CommonResult.class);
    }

    @GetMapping("/consumer/dataInfo/get/{id}")
    public CommonResult<DataInfo> getDataInfoById(@PathVariable("id") Long id){
        log.info("*****使用消费者进行DataInfo查询*****");
        return restTemplate.getForObject(DataInfo_URL + "/dataInfo/get/" + id, CommonResult.class);
    }

    @DeleteMapping("/consumer/dataInfo/delete/{id}")
    public CommonResult<DataInfo> deleteDataInfoById(@PathVariable("id") Long id){
        log.info("*****使用消费者进行DataInfo删除*****");
        CommonResult commonResult = restTemplate.getForObject(DataInfo_URL + "/dataInfo/get/" + id, CommonResult.class);
        if (commonResult.getCode() == 200){
            restTemplate.delete(DataInfo_URL + "/dataInfo/delete/" + id);
            return new CommonResult(200,"删除id：" + id + "的DataInfo成功",commonResult.getData());
        }else{
            return new CommonResult(400,"删除id：" + id + "的DataInfo不存在，无法删除");
        }

    }

    @PutMapping("/consumer/dataInfo/put")
    public CommonResult<DataInfo> updateDataInfo(@RequestBody DataInfo dataInfo){
        log.info("*****使用消费者进行DataInfo更新*****");
        Long id = dataInfo.getId();
        CommonResult commonResult = restTemplate.getForObject(DataInfo_URL + "/dataInfo/get/" + id, CommonResult.class);
        if (commonResult.getCode() == 200){
            restTemplate.put(DataInfo_URL + "/dataInfo/put", dataInfo, CommonResult.class);
            return new CommonResult(200,"更新id：" + id + "的DataInfo成功",commonResult.getData());
        }else{
            return new CommonResult(400,"更新id：" + id + "的DataInfo不存在，更新失败");
        }

    }

}
