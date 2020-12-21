package cn.edu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/7 15:05
 * 返回给前端的通用json串
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    /**
     * 自定义两个参数的构造方法
     * @param code
     * @param message
     */
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
