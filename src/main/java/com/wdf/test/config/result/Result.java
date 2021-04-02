package com.wdf.test.config.result;

import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: Result
 * @Author WDF
 * @Description 返回数据体，JSON格式，根据不同的业务又不同的JSON体。
 * 我们要设计一个返回体类Result
 * @Date 2020/11/25 9:01
 * @Copyright Dareway 2020/11/25
 * @Version 1.0
 **/
@Data
public class Result implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    private ResultCode resultCode;

    public Result(){
    }

    public Result(ResultCode resultCode, Object data){
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public Result(Object data){
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public static Result success(){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure(ResultCode resultCode ){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data){
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }
}
