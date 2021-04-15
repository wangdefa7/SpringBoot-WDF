package com.wdf.test.config.msgconverter;



import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.wdf.test.config.result.Result;
import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.util.StreamUtils;

public class Form2DataObjectConverter extends AbstractHttpMessageConverter<String> {
    @Autowired
    ObjectMapper mapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(Form2DataObjectConverter.class);

    public Form2DataObjectConverter() {
        super(MediaType.APPLICATION_FORM_URLENCODED);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
       // return clazz.equals(Map.class);
        return true;
    }

    @Override
    protected String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException {
        String paramsInEnc = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("utf-8"));
        //Map params = new HashMap();
        //params.put("data",paramsInEnc);

        LOGGER.error("输入的readInternal---拿到信息--paramsInEnc:{}" ,paramsInEnc);
        return paramsInEnc;
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
