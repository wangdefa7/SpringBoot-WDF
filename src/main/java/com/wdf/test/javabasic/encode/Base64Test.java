package com.wdf.test.javabasic.encode;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Bsee64 测试类
 */
public class Base64Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Base64Test base64Test = new Base64Test();
        base64Test.testOneBase64();
    }

    /**
     * 与sun.mis c套件和Apache Commons Codec所提供的Base64编解码器来比较的话，Java 8提供的Base64拥有更好的效能。
     * 实际测试编码与解码速度的话，Java 8提供的Base64，要比sun.mis c套件提供的还要快至少11倍，
     * 比Apache Commons Codec提供的还要快至少3倍。因此在Java上若要使用Base64，
     * 这个Java 8底下的java .util套件所提供的Base64类别绝对是首选！
     * @throws UnsupportedEncodingException
     */
    public void testOneBase64() throws UnsupportedEncodingException {

        final Base64.Decoder decoder = Base64.getDecoder();
        final Base64.Encoder encoder = Base64.getEncoder();
        final String text = "字串文字";
        final byte[] textByte = text.getBytes("UTF-8");
//编码
        final String encodedText = encoder.encodeToString(textByte);
        System.out.println(encodedText);
//解码
        System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
    }
}
