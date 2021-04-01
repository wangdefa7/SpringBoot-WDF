package com.wdf.test.javamedium.thread.excutor;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: IpayDelayQueue
 * @Author WDF
 * @Description //TODO
 * @Date 2021/4/1 16:01
 * @Copyright Dareway 2021/4/1
 * @Version 1.0
 **/
public class OrderDelayed implements Delayed{
    /* 触发时间*/
    private long time;
    String name;
    boolean endFlag;//轮询结束标志，0代表后面还有轮询任务，1代表这次是本订单最后一次轮询任务
    String orderType;//订单类型，用于区分是付款订单还是退款订单

    public OrderDelayed(String name,long time, TimeUnit unit, boolean endFlag, String orderType) {
        this.name = name;
        //当前系统时间 加上 传入的等待时间
        this.time = System.currentTimeMillis() + (time > 0? unit.toMillis(time): 0);
        this.endFlag = endFlag;
        this.orderType = orderType;
    }

    public OrderDelayed(long time, TimeUnit unit, boolean endFlag) {
        this.time = System.currentTimeMillis() + (time > 0? unit.toMillis(time): 0);
        this.endFlag = endFlag;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        //判断avaibleTime是否大于当前系统时间，并将结果转换成MILLISECONDS
        //只有delay时间小于0的元素才能够被取出。
        //由于是阻塞队列，当没有条件的时候会阻塞
        return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        OrderDelayed orderDelayed = (OrderDelayed) o;
        long diff = this.time - orderDelayed.time;
        // 改成>=会造成问题
        if (diff <= 0) {
            return -1;
        }else {
            return 1;
        }
    }

    public boolean isEndFlag() {
        return endFlag;
    }

    public String getOrderType() {
        return orderType;
    }
}
