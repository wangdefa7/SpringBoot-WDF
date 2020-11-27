package com.wdf.test.javabasic.http.get;

import java.io.BufferedReader;
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

}
