package leetcode.code;

import java.io.IOException;

public class A {

    public static void main(String[] args) {
        //一个字节占两个字符
        System.out.println("没人比我更懂java".toCharArray().length);

        String s = new String(new char[] {'没','人','比','我','更','懂','j','a','v','a'});
        String si = "没人比我更懂java";
        System.out.println(s == si);
        System.out.println(s.intern() == "没人比我更懂java");
        System.out.println(s == si.intern());

        System.out.print(method(0));
    }
    private static Integer method(Integer i){
        try{
            if(i++ > 0)
                throw new IOException();
            return i++;
        }catch (IOException e){
            i++;
            return i++;
        }catch (Exception e){
            i++;
            return i++;
        }finally {
            return i++;
        }
    }
}