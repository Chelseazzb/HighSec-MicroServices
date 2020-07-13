package highsec.microservices.springcloud.controller;

import highsec.microservices.springcloud.entity.CommonResult;
import highsec.microservices.springcloud.entity.DataInfo;
import highsec.microservices.springcloud.service.DataInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName : DataInfoController
 * @Description : 控制层REST接口
 * @Modified_by :
 * @Version : 1.0
 **/
@RestController
@Slf4j
public class DataInfoController {

    @Resource
    private DataInfoService dataInfoService;

    @PostMapping(value = "/dataInfo/create")
    public CommonResult create(@RequestBody DataInfo dataInfo){  //插入一条业务数据

        int result = dataInfoService.createDataInfo(dataInfo);
        log.info("********插入Payment结果：" + result + "********"); //打印日志
        if (result > 0){
            return new CommonResult(200 , "插入DataInfo数据成功", result);
        }else {
            return new CommonResult(444, "插入DataInfo失败", null);
        }
    }

    @GetMapping(value = "/dataInfo/get/{id}")
    public CommonResult<DataInfo> getDataInfoById(@PathVariable("id") Long id){  //通过id查询业务数据

        DataInfo result = dataInfoService.getDataInfoById(id);
        log.info("********查询DataInfo结果：" + result + "*******"); //打印日志
        if (result != null){
            return new CommonResult(200 , "查询DataInfo成功，id为：" + id, result);
        }else {
            return new CommonResult(444, "查询DataInfo没有记录，id为：" + id, null);
        }
    }

    @DeleteMapping(value = "/dataInfo/delete/{id}")
    public CommonResult deleteDataInfoById(@PathVariable("id") Long id){ //通过id删除业务数据
        int result = dataInfoService.deleteDataInfoById(id);
        log.info("********删除DataInfo结果：" + result + "********"); //打印日志
        if (result > 0){
            return new CommonResult(200 , "删除DataInfo数据成功", result);
        }else {
            return new CommonResult(444, "删除DataInfo失败", null);
        }
    }

    @PutMapping(value = "/dataInfo/put")
    public CommonResult updateDataInfo(@RequestBody DataInfo dataInfo){ //更新业务数据
        int result = dataInfoService.updateDataInfo(dataInfo);
        log.info("********更新DataInfo结果：" + result + "********"); //打印日志
        if (result > 0){
            return new CommonResult(200 , "更新DataInfo数据成功", result);
        }else {
            return new CommonResult(444, "更新DataInfo失败", null);
        }
    }
}
