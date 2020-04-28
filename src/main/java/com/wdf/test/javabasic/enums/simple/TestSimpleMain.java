package com.wdf.test.javabasic.enums.simple;

/**
 * @ClassName: TestSimpleMain
 * @Description:
 * @Auther: WDF
 * @Date: 2020/4/2815:37
 * @Version: 1.0
 **/
public class TestSimpleMain {

    public static void main(String[] args) {

        showColor( TestSimpleEnum.RED );

    }

    static void showColor(TestSimpleEnum color){
        switch ( color ) {
            case BLANK:
                System.out.println( color );
                break;
            case RED :
                System.out.println( color );
                break;
            default:
                System.out.println( color );
                break;
        }

    }
}
