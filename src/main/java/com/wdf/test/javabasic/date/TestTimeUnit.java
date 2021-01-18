package com.wdf.test.javabasic.date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * @ClassName: TestTimer
 * @Author WDF
 * @Description //TODO
 * @Date 2021/1/18 11:33
 * @Copyright Dareway 2021/1/18
 * @Version 1.0
 **/




/**
 * Created by lyq on 2017/1/22.
 * 原创
 */
public class TestTimeUnit {
    public static void main(String[] args){
        //3600分钟 转换成 小时 是多少
        System.out.println(TimeUnit.HOURS.convert(3600, TimeUnit.MINUTES));
        //3600分钟 转换成 天 是多少
        System.out.println(TimeUnit.DAYS.convert(3600, TimeUnit.MINUTES));
        //3600分钟 转换成 秒 是多少
        System.out.println(TimeUnit.SECONDS.convert(3600, TimeUnit.MINUTES));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //时间毫秒加减  currentTimeMillis
        long millisTime = System.currentTimeMillis();
        long addMillisTime = millisTime + TimeUnit.MILLISECONDS.convert(1,TimeUnit.SECONDS);
        System.out.println("current dateTime:"+sdf.format(new Date(millisTime))+"  add 1 seconds ="+ sdf.format(new Date(addMillisTime)));

        //时间纳秒加减
        long nanoTime = System.nanoTime();
        long addNanoTime = nanoTime + TimeUnit.NANOSECONDS.convert(1,TimeUnit.MINUTES);
    }
}
