package highsec.microservices.springcloud.dao;

import highsec.microservices.springcloud.entity.DataInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper //数据层接口
public interface DataInfoDao {

    public int createDataInfo(DataInfo dataInfo); //新增一条记录,如果插入成功，返回值大于0

    public DataInfo getDataInfoById(@Param("id") Long id); //通过id查询DataInfo

    public int updateDataInfo(DataInfo dataInfo); //更改数据信息

    public int deleteDataInfoById(@Param("id") Long id); //通过id删除DataInfo
}
