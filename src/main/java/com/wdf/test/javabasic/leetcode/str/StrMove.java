package com.wdf.test.javabasic.leetcode.str;

/**
 * @ClassName: str
 * @Author WDF
 * @Description 字符串
 * @Date 2020/10/10 16:08
 * @Copyright Dareway 2020/10/10
 * @Version 1.0
 **/
public class StrMove {

    public static void main(String[] args) {
        StrMove strMove = new StrMove();
        strMove.strMoveNum("abcdef",2);
    }

    /**
     字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
     该函数将返回左旋转两位得到的结果"cdefgab"。
     **/
    public String strMoveNum(String str,int num){
        char[] chars = str.toCharArray();
        char[] charsCopy = new char[num];
        StringBuffer stringBuffer = new StringBuffer();
        int a = 0;
        for (int i = 0; i<str.length();i++){
            if (num > i){
                charsCopy[i] = chars[i];
            }
            if (i >= num){
                chars[i-num] = chars[i];
                stringBuffer.append(chars[i]);
            }
        }
        for (int i = str.length()-num;i < str.length();i++){
                chars[i] = charsCopy[a++];
                stringBuffer.append(chars[i]);
        }
        System.out.println(chars);
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    /*
     网上的例子，一句代码
     **/
    public String strMoveNum2(String s, int n){
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    /*
     思路一致，代码简洁
     * */
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }

}
