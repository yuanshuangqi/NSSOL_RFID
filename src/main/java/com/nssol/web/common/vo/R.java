package com.nssol.web.common.vo;

import com.nssol.web.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局统一返回类
 */
@Setter
@Getter
@ApiModel(value = "请求返回对象",description ="全局统一返回对象")
public class R {
    @ApiModelProperty(value = "请求是否成功, true-成功;false-失败")
    private Boolean success;
    @ApiModelProperty(value = "请求返回码,200-请求成功,500-系统内部错误")
    private Integer code;
    @ApiModelProperty(value = "返回具体信息")
    private String message;
    @ApiModelProperty(value = "请求返回的数据")
    private Map<String,Object> data = new HashMap<>();
    //私有化构造器
    private R() { }
    // 成功返回
    public static R ok(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMsg());
        return r;
    }
    // 错误返回
    public static R error(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMsg());
        return r;
    }
    // 链式设置data
    public R data(String key,Object value){
        this.data.put(key, value);
        return this;
    }
    // 链式设置data
    public R data(Object value){
        this.data.put("items", value);
        return this;
    }
    // 链式设置data
    public R data(Map<String,Object> map){
        this.data = map;
        return this;
    }
    // 链式设置code
    public R code(Integer code){
        this.setCode(code);
        return this;
    }
    // 链式设置message
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public static R setResult(ResultCodeEnum result){
        R r = new R();
        r.setSuccess(result.getSuccess());
        r.setCode(result.getCode());
        r.setMessage(result.getMsg());
        return r;
    }
}
