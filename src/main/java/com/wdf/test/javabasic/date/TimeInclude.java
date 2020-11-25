package com.wdf.test.javabasic.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: TimeInclude
 * @Author WDF
 * @Description 时间是否包含在范围内
 * @Date 2020/11/17 13:17
 * @Copyright Dareway 2020/11/17
 * @Version 1.0
 **/
public class TimeInclude {

    public static void main(String[] args) {
        TimeInclude main = new TimeInclude();
        main.timeInclude();
    }

    public void  timeInclude(){
        String jyrq = "2020-11-17";
        String beginTime = jyrq + " 00:00:00";
        String endTime = jyrq + " 23:59:59";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date paseEndTime,paseBeginTime;
        try {
            paseBeginTime = dateFormat.parse(beginTime);
            paseEndTime = dateFormat.parse(endTime);
            /** 2020-11-17 23:59:59.111 包括
             *  2020-11-17 00:00:00 不包括
             *  2020-11-18 00:00:00 不包括
             */
            String time = "2020-11-17 23:59:59.111 ";
            Date jysj = dateFormat.parse(time);
            //判断日期是否在指定周期内
            System.out.println("交易时间：" + jysj.getTime());
            System.out.println("开始：" + paseBeginTime.getTime());
            System.out.println("结束：" + paseEndTime.getTime());
            if(!(jysj.after(paseBeginTime) && jysj.before(paseEndTime))) {
                System.out.println("不在");
            }else {
                System.out.println("在");
            }
        } catch (ParseException e) {
        }


    }

}
