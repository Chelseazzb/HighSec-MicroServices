package highsec.microservices.springcloud.service.impl;

import highsec.microservices.springcloud.dao.DataInfoDao;
import highsec.microservices.springcloud.entity.DataInfo;
import highsec.microservices.springcloud.service.DataInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName : DataInfoServiceImpl
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
@Service //标志这是服务类的实现类
public class DataInfoServiceImpl implements DataInfoService {

    @Resource
    private DataInfoDao dataInfoDao;

    @Override
    public int createDataInfo(DataInfo dataInfo) {
        return dataInfoDao.createDataInfo(dataInfo);
    }

    @Override
    public DataInfo getDataInfoById(Long id) {
        return dataInfoDao.getDataInfoById(id);
    }

    @Override
    public int updateDataInfo(DataInfo dataInfo) {
        return dataInfoDao.updateDataInfo(dataInfo);
    }

    @Override
    public int deleteDataInfoById(Long id) {
        return dataInfoDao.deleteDataInfoById(id);
    }
}
