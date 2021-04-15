package com.wdf.test.config.msgconverter;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import com.wdf.test.config.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.util.StreamUtils;

public class JSON2DataObjectConverter extends AbstractHttpMessageConverter<String> {
    @Autowired
    ObjectMapper mapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(JSON2DataObjectConverter.class);

    public JSON2DataObjectConverter() {
        super(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_UTF8);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
//        return clazz.equals(Map.class);
        return true;
    }

    @Override
    protected String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException {
        String paramsIn = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("utf-8"));
        String params = null;

        LOGGER.error("输入的readInternal---拿到信息--paramsIn:{}" ,paramsIn);

        return params;
    }

    @Override
    protected void writeInternal(String t, HttpOutputMessage outputMessage) throws IOException {
        Result result = new Result(t);
        OutputStream out = outputMessage.getBody();
        out.write(this.mapper.writeValueAsBytes(result));
        LOGGER.error("输出的writeInternal---拿到信息--result:{}" ,result.toString());
        out.flush();
    }
}
