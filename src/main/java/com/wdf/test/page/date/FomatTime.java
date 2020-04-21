package com.wdf.test.page.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化时间
 */
public class FomatTime {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
        Date date = new Date();
        String date1 = "";
        System.out.println(simpleDateFormat.parse(date1));
    }
}
