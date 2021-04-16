package com.wdf.test.javabasic.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileInputStreamTest {

    public static String  path = "E:\\test.txt";

    public static void main(String[] args) {
        readTxt();
        readTxt2();
        FileInputStream fileInnputStream = null;
        try {
            //创建
//            fileInnputStream = new FileInputStream("E:\\text.txt");
//            //使用
//            System.out.println(fileInnputStream.read());
//            System.out.println(fileInnputStream.read());

            fileInnputStream = new FileInputStream(path);

            //使用
            System.out.println(fileInnputStream.read());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭流，因为流在最后执行，所以也会抛异常。并不与try里面的一致
                fileInnputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Map readTxt(){
        File file = new File(path);
        Map map = new HashMap<String,Object>(1);
        map.put("file",file);

        InputStream in = null;
        byte[] tempByte = new byte[1024];
        int byteread = 0;
        try {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            File file1 = (File) map.get("file");
            in = new FileInputStream(file1);
//            while ((byteread = in.read(tempByte)) != -1 ) {
//                System.out.write(tempByte, 0, byteread);
//            }
            map.put("data",in);
            //in.close();
//            InputStream in2 = (InputStream) map.get("data");
//            System.out.println(in2.available());
//            StringBuilder str = new StringBuilder();
//            while ((byteread = in2.read(tempByte)) != -1 ) {
//                System.out.write(tempByte, 0, byteread);
//                str.append(tempByte);
//            }
//            System.out.println(str.toString());
//            in2.close();
            return map;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if (in != null) {
                //in.close();
            }
        }
        return map;
    }

    public static void readTxt2() {
        // TODO Auto-generated method stub
        File file = new File(path);
        BufferedReader reader = null;
        String tempString = null;
        int line =1;

        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            while ((tempString = reader.readLine()) != null) {
                System.out.println("Line"+ line + ":" );
                System.out.println(tempString);
                line ++ ;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
