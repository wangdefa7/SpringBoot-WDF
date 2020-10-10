package com.wdf.test.javabasic.String;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @ClassName: CodingStr
 * @Author WDF
 * @Description 编码格式乱码的处理
 * @Date 2020/10/10 10:13
 * @Copyright Dareway 2020/10/10
 * @Version 1.0
 **/
public class CodingStr {

    public static void main(String[] args) {
        CodingStr main = new CodingStr();
        main.testErrorStr();
    }

    public void testErrorStr(){
        String str = "锟斤拷锟斤拷锟叫猴拷失锟杰ｏ拷锟斤拷确锟斤拷锟秸匡拷锟剿伙拷锟斤拷锟斤拷效锟斤拷";
        String gbk2UtfString = null;
        try {
            System.out.println( URLDecoder.decode(str,"UTF-8"));
            gbk2UtfString = new String(str.getBytes("GBK"), "Unicode");//
            gbk2UtfString = new String(str.getBytes("Unicode"), "UTF-8");//Unicode

            System.out.println("GBK转换成UTF-8：" + gbk2UtfString);
            String gbk2Utf2GbkString = new String(gbk2UtfString.getBytes("UTF-8"), "GBK");
            System.out.println("GBK转换成UTF-8再转成GBK：" + gbk2Utf2GbkString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         * 总结一下，锟斤拷是怎么产生的？
         *
         * 源于GBK字符集和Unicode字符集之间的转换问题。
         * Unicode和老编码体系的转化过程中，肯定有一些字，用Unicode是没法表示的，
         * Unicode官方用了一个占位符(REPLACEMENT CHARACTER)来表示这些文字，这就是：U+FFFD
         *
         * U+FFFD的UTF-8编码出来，恰好是 '\xef\xbf\xbd'。
         *
         * 重复多次，例如 '\xef\xbf\xbd\xef\xbf\xbd'，
         * 然后放到GBK/CP936/GB2312/GB18030的环境中显示的话，
         * 一个汉字2个字节，最终的结果就是：锟斤拷——锟(0xEFBF)，斤（0xBDEF），拷（0xBFBD）。
         */

    }
}
