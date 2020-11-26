package com.wdf.test.javabasic.md5;

import java.security.MessageDigest;

/**
 * @ClassName: MD5Test
 * @Author WDF
 * @Description //TODO
 * @Date 2020/11/26 13:45
 * @Copyright Dareway 2020/11/26
 * @Version 1.0
 **/
public class MD5Test {

    public static void main(String[] args) {
        MD5Test md5Test = new MD5Test();
        String str = MD5("123456");
        System.out.println(str);
        System.out.println(str.toLowerCase());
    }

    public final static String MD5(String s) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
