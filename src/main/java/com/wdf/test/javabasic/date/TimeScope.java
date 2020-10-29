package com.wdf.test.javabasic.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ClassName: TimeScope
 * @Author WDF
 * @Description 查询时间范围
 * @Date 2020/10/20 16:42
 * @Copyright Dareway 2020/10/20
 * @Version 1.0
 **/
public class TimeScope {


    public static void main(String[] args) {
        System.out.println(getMonthList("2020-02-01","2020-10-01"));
        System.out.println(getDayNum("2020-09-01","2020-09-03"));
        System.out.println(getMothNum("2020-09-01","2020-09-03"));

    }

    public static String getMonthList(String beginDateStr, String endDateStr) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
        //返回的月份列表
        String sRet = "";

        //定义一些变量
        Date beginDate = null;
        Date endDate = null;

        GregorianCalendar beginGC = null;
        GregorianCalendar endGC = null;

        try {
            //将字符串parse成日期
            beginDate = f.parse(beginDateStr);
            endDate = f.parse(endDateStr);

            //设置日历
            beginGC = new GregorianCalendar();
            beginGC.setTime(beginDate);

            endGC = new GregorianCalendar();
            endGC.setTime(endDate);

            //直到两个时间相同
            while(beginGC.getTime().compareTo(endGC.getTime())<=0){
                //累加字符串,用单引号分隔
                if (sRet.equals("")) {
                    sRet += beginGC.get(Calendar.YEAR) + "-" + (beginGC.get(Calendar.MONTH)+1);
                }
                else {
                    sRet += "," + beginGC.get(Calendar.YEAR) + "-" + (beginGC.get(Calendar.MONTH)+1);
                }

                //以月为单位，增加时间
                beginGC.add(Calendar.MONTH,1);
            }
            return sRet;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @Author WDF
     * @Description 获取开始结束时间内的天数
     * @Date 2020/10/21 8:18
     * @Param [begin, end]
     * @return int
     **/
    public static int  getDayNum(String begin,String end){
        //月份的MM一定大写，否则与秒mm冲突
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat test = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int monthNum = 0;
        Date beginDate = null;
        Date endDate = null;
        //日历
        GregorianCalendar beginGC = null;
        GregorianCalendar endGC = null;
        try{
            //字符串转日期
            beginDate = format.parse(begin);
            endDate = format.parse(end);
            //设置日历
            beginGC = new GregorianCalendar();
            beginGC.setTime(beginDate);
            endGC = new GregorianCalendar();
            endGC.setTime(endDate);
            //开始时间小于结束时间
            while (beginGC.getTime().compareTo(endGC.getTime()) <=0){
                System.out.println(test.format(beginGC.getTime())+"  "+test.format(endGC.getTime()));
                beginGC.add(Calendar.DAY_OF_MONTH,1);
                monthNum++;
            }
            return monthNum;
        }catch (Exception e){
            System.out.println("在时间转换计算跨度时出现异常。");
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * @Author WDF
     * @Description 计算时间跨度之间有几个月
     * @Date 2020/10/20 17:03
     * @Param [begin, end]
     * @return int
     **/
    public static int  getMothNum(String begin,String end){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        int monthNum = 0;
        Date beginDate = null;
        Date endDate = null;
        //日历
        GregorianCalendar beginGC = null;
        GregorianCalendar endGC = null;
        try{
            //字符串转日期
            beginDate = format.parse(begin);
            endDate = format.parse(end);
            //设置日历
            beginGC = new GregorianCalendar();
            endGC = new GregorianCalendar();
            beginGC.setTime(beginDate);
            endGC.setTime(endDate);
            //开始时间小于结束时间
            while (beginGC.getTime().compareTo(endGC.getTime()) <=0){
                beginGC.add(Calendar.MONTH,1);
                monthNum++;
            }
            return monthNum;
        }catch (Exception e){
            System.out.println("在时间转换计算跨度时出现异常。");
            e.printStackTrace();
        }
        return -1;
    }
}
