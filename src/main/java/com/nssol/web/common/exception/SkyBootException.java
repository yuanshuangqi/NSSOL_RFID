package com.nssol.web.common.exception;

import com.nssol.web.common.constants.ResultCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 */
@Getter
@Setter
public class SkyBootException extends RuntimeException {
    private Integer code;

    /**
     * 接受状态码和信息
     * @param code 状态码
     * @param message 异常信息
     */
    public SkyBootException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    /**
     * 接受枚举类型
     * @param resultCodeEnum 异常枚举
     */
    public SkyBootException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMsg());
        this.code = resultCodeEnum.getCode();
    }

    /**
     * 重写 toString 方法 打印message 信息
     * @return
     */
    @Override
    public String toString() {
        return "SkyBootException{" +
                "code=" + code +
                ",message=" + this.getMessage() +
                '}';
    }
}
