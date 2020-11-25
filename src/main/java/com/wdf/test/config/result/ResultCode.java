package com.wdf.test.config.result;

/**
 * @ClassName: ResultCode
 * @Author WDF
 * @Description //TODO
 * @Date 2020/11/25 8:40
 * @Copyright Dareway 2020/11/25
 * @Version 1.0
 **/
public enum ResultCode {

    SUCCESS(1,"成功"),
    FAILD(5,"失败");

    private Integer code;
    private String message;

    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer code(){
        return this.code;
    }

    public String message(){
        return this.message;
    }


}
