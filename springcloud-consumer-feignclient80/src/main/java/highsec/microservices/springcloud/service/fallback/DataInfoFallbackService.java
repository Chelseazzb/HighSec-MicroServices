package highsec.microservices.springcloud.service.fallback;

import highsec.microservices.springcloud.entity.CommonResult;
import highsec.microservices.springcloud.entity.DataInfo;
import highsec.microservices.springcloud.service.DataInfoFeignService;
import org.springframework.stereotype.Component;

/**
 * @ClassName : DataInfoFallbackService
 * @Description : Feign客户端接口的服务降级实现类
 * @Modified_by :
 * @Version : 1.0
 **/
@Component
public class DataInfoFallbackService implements DataInfoFeignService {
    @Override
    public CommonResult create(DataInfo dataInfo) {
        return new CommonResult(408,
                "微服务消费者80的创建DataInfo失败，请检查并重试，o(╥﹏╥)o");
    }

    @Override
    public CommonResult<DataInfo> getDataInfoById(Long id) {
        return new CommonResult<DataInfo>(408,
                "微服务消费者80的查询DataInfo失败，请检查并重试，o(╥﹏╥)o");
    }

    @Override
    public CommonResult deleteDataInfoById(Long id) {
        return new CommonResult(408,
                "微服务消费者80的删除DataInfo失败，请检查并重试，o(╥﹏╥)o");
    }

    @Override
    public CommonResult updateDataInfo(DataInfo dataInfo) {
        return new CommonResult(408,
                "微服务消费者80的更新DataInfo失败，请检查并重试，o(╥﹏╥)o");
    }
}
