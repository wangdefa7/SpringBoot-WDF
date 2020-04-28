package com.wdf.test.javabasic.address;

/**
 * @ClassName: AdrressValue
 * @Description: 地址传递和值传递
 * 上java参数传递只有一种情况，那就是值传递。
 * 所不同的是，一般说的"引用传递"，在实际中传递的不过是引用对象的地址值
 * @Auther: WDF
 * @Date: 2020/4/2711:04
 * @Version: 1.0
 **/
public class AdrressValue {

    public static void main(String[] args) {
        StringBuffer ssa = new StringBuffer("xxx");
        StringBuffer ssb = new StringBuffer("ooo");
        test(ssa,ssb);
        System.out.println("--   " + ssa+ "  " + ssb);//xxxhhhh  ooo
    }

     static void test(StringBuffer a, StringBuffer b) {
        System.out.println("b "+ b);
        StringBuffer c = a.append("hhhh");//a在append以后，把主方法里面的参数也改变了
        System.out.println("c "+ c);
        a = b;
        System.out.println("a  "+a);
        b = c;
        System.out.println("test: " + a + "  " + b);//ooo  xxxhhhh
    }
}
