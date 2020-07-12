package highsec.microservices.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName : CommonResult
 * @Author : Zhai Zhibin
 * @Date : 2020/7/2 18:32
 * @Description : ToDo
 * @Modified_by :
 * @Version : 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code; //操作码
    private String message; //操作信息
    private T data; //返回数据

    //考虑到有可能data为空
    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
