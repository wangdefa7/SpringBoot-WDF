package com.wdf.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author WDF
 * @Description 配置加载外部的配置文件
 * @Date 2021/4/1 10:09
 * @Param
 * @return
 **/
@Component
public class PayConfig implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(PayConfig.class);

    //@Value("${payConfig}")
    private String payConfig;

    private final Map<String, String> payConfigMap = new HashMap<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        boolean configInWar = true;//配置文件是否是包内
        payConfig = payConfig.trim();
        if (payConfig != null && !"".equals(payConfig)) {
            String[] configFiles = payConfig.split(",");
            for (String configFile : configFiles) {
                String configFileName = configFile + ".properties";
                //获取项目根路径
                File file = new File("");
                String rootPath = file.getAbsolutePath();
                String filePath = rootPath + "/config/" + configFileName;
                File testFile = new File(filePath);
                if (testFile.exists()) {   //配置文件在jar包同目录的config文件夹内
                    configInWar = false;
                } else {
                    filePath = rootPath + "/" + configFileName;
                    testFile = new File(filePath);
                    //配置文件在jar包同目录内
                    //配置文件在jar包内部
                    configInWar = !testFile.exists();
                }
                Properties properties = new Properties();
                if (configInWar) {   //包内
                    logger.info("开始加载包内配置文件{}", configFileName);
                    try {
                        properties = PropertiesLoaderUtils.loadAllProperties(configFileName);
                    } catch (IOException e) {
                        logger.info("加载配置文件{}异常", configFileName, e);
                    }
                } else {   //包外
                    logger.info("开始加载包外配置文件{}，文件路径{}", configFileName, filePath);
                    BufferedReader bufferedReader = null;
                    try {
                        bufferedReader = new BufferedReader(new FileReader(filePath));
                    } catch (FileNotFoundException e) {
                        logger.info("加载配置文件{}异常", configFileName, e);
                    }
                    try {
                        properties.load(bufferedReader);
                    } catch (IOException e) {
                        logger.info("加载配置文件{}异常", configFileName, e);
                    }
                }
                Set<Object> objects = properties.keySet();
                for (Object object : objects) {
                    String key = object.toString();
                    logger.info(key + ": " + properties.getProperty(key));
                    payConfigMap.put(key, properties.getProperty(key));
                }
                logger.info("成功加载配置文件{}", configFileName);
            }
        } else {
            logger.info("未配置系统启动后需加载的配置文件名！");
        }
    }

    /**
     * @Author WDF
     * @Description 取配置文件中 设置的 参数
     * @Date 2021/4/1 10:16
     * @Param [key]
     * @return java.lang.String
     **/
    public String getConfigByKey(String key) {
        return payConfigMap.get(key);
    }
}
