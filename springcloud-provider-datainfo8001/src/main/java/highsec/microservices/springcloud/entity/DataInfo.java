package highsec.microservices.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName : DataInfo
 * @Description : 业务数据实体类
 * @Modified_by :
 * @Version : 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataInfo implements Serializable {

    private Long id; //主键id
    private String dataName; //数据名称
    private String dataType; //数据类型
    private String dataOwner; //数据所有者
    private String dataLocation; //数据位置
    private String dataSize; //数据大小
    private Date uploadTime; //数据上传时间
    private String dataLevel; //数据级别
    private String dataDescription; //数据描述

}
