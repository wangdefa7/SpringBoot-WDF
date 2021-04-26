package com.wdf.test.javabasic.String;

/**
 * @ClassName: StringTest
 * @Author WDF
 * @Description //TODO
 * @Date 2021/4/22 9:55
 * @Copyright Dareway 2021/4/22
 * @Version 1.0
 **/
public class StringTest {

    public static void main(String[] args) {
        StringTest main = new StringTest();
        main.test1();
    }

    private void test1(){
        String str = "YHRYBH:0,BRJZKH:1,BLH:2,BRXM:3,FPBH:4,JYQDBS:5,YWLX:6,JYJE:7,KHH:8,KHZH:9,JYLSH:10,JYCKH:11,DDBH:12,YJYH:13,YBFDJE:14,GRZHZFJE:15,XJZFJE:16,YLJMJE:17,YLBZJE:18,ZDBH:19,BRJZKYE:20,CZM:21,JYSJ:22,JYYLX:23,JYSHBH:24,JYZDBH:25,JYSBBS:26,JYRZZH:27,YHLSH:28,YHCKH:29,PCH:30,JYZT:31,FLAG:32,MZZYBS:33,YHRYXM:34,SFZHM:35,SBCSBM:36,YDDBH:37,YHID:38,ACCNO";
        String[] arry = str.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arry.length; i++) {
            String[] arrTemp = arry[i].split(":");
            if (arrTemp.length < 2) {
                continue;
            }
            stringBuilder.append(arrTemp[0] + ",");
            //stringBuilder.append(arrTemp[1] + ":" + arrTemp[0] + ",");
        }
        System.out.println(stringBuilder.toString());
    }
}
