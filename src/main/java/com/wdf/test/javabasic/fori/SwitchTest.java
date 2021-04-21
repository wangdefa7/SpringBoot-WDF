package com.wdf.test.javabasic.fori;

/**
 * @ClassName: SwitchTest
 * @Author WDF
 * @Description //TODO
 * @Date 2021/4/21 14:46
 * @Copyright Dareway 2021/4/21
 * @Version 1.0
 **/
public class SwitchTest {

    public static void main(String[] args) {
        SwitchTest main = new SwitchTest();
        main.method(null);
    }

    /**
     * @Author WDF
     * @Description 当 switch 括号内的变量类型为 String 并且此变量为外部参数时，
     * 必须先进行 null判断。
     * @Date 2021/4/21 14:47
     * @Param [param]
     * @return void
     **/
    public  void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }
}
