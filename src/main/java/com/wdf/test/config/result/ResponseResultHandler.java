package com.wdf.test.config.result;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: ResponseResultHandler
 * @Author WDF
 * @Description //TODO
 * @Date 2020/11/25 9:56
 * @Copyright Dareway 2020/11/25
 * @Version 1.0
 **/
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {


    public static final String RESPONESE_RESULT_ADM = "RESPONESE_RESULT_ADM";

    //是否请求包含了包装注解
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //判断请求是否包含标记
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(RESPONESE_RESULT_ADM);
        return responseResultAnn != null;
    }

/*    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info("进入返回体 格式重写 处理中...");
        if (body instanceof Result){
            log.info("返回值异常 做包装 处理...");
            Result errorResult = (Result) body;
            return Result.failure(errorResult.getResultCode(),errorResult.getMessage());
        }
        return Result.success(body);
    }*/
@Override
public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
    ResponseResult responseResultAnn = (ResponseResult) RequestContextHolderUtil.getRequest().getAttribute(ResponseResultInterceptor.RESPONESE_RESULT_ADM);

    Class<? extends Result> resultClazz = responseResultAnn.value();

    if (resultClazz.isAssignableFrom(Result.class)) {
        //如果返回的已经是 Result 直接返回
        if (body instanceof Result) {
            return body;
        } else if (body instanceof String) {//如果返回的已经是 String 直接返回
            return JSONObject.toJSONString(Result.success(body));
        }
        return Result.success(body);
    }
    return body;
}


}
