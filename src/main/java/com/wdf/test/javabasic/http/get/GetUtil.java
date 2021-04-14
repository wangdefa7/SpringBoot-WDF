package com.wdf.test.javabasic.http.get;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;//一般连接到网上的都用这个

/**
 * @ClassName: GetUtile
 * @Author WDF
 * @Description 网络请求的get工具
 * @Date 2020/11/27 9:36
 * @Copyright Dareway 2020/11/27
 * @Version 1.0
 **/
public class GetUtil {
    private static Logger logger = LoggerFactory.getLogger(GetUtil.class);

    public static void sendGet(String urlAddess) throws IOException
    {

        try {
            HttpURLConnection urlcon=null;
            URL url=new URL(urlAddess);
            urlcon=(HttpURLConnection) url.openConnection();
            urlcon.setReadTimeout(5000);
            urlcon.setConnectTimeout(5000);
            urlcon.connect();
            BufferedReader bf=new BufferedReader(new InputStreamReader(urlcon.getInputStream(),"gbk"));
//            BufferedReader bf=new BufferedReader(new InputStreamReader(urlcon.getInputStream(),"utf-8"));
            String line=bf.readLine();
            while(line!=null)
            {
                System.out.println(line);
                line=bf.readLine();
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @Author WDF
     * @Description HttpClient 通过流的下载方式
     * @Date 2021/4/14 15:26
     * @Param [url]
     * @return java.lang.String
     **/
    public String getStreamFile(String url) throws Exception {
        //HttpClient client = HttpClientUtils.createSSLInsecureClient();
        HttpClient client =  HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        HttpResponse response = client.execute(get);
//        获取消息头
//        Header[] headers = response.getAllHeaders();
//        for (Header header : headers) {
//            System.out.println(MessageFormat.format("header:{0}={1}", header.getName(), header.getValue()));
//        }
        String fileName = response.getHeaders("Content-Disposition")[0].getValue().split("filename=")[1];
        logger.info("文件名为" + fileName);

        if (response.getStatusLine().getStatusCode() == 200) {
            //得到实体
            HttpEntity entity = response.getEntity();
            byte[] data = EntityUtils.toByteArray(entity);
            //存入磁盘
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(data);
            fos.close();
            logger.info("文件下载成功！");
        } else {
            throw new Exception("文件下载失败！Http状态码为" + response.getStatusLine().getStatusCode());
        }
        return fileName;
    }

}
