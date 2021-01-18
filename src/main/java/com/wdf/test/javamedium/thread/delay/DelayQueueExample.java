package com.wdf.test.javamedium.thread.delay;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: DelayQueueExample
 * @Author WDF
 * @Description //TODO
 * @Date 2021/1/11 10:57
 * @Copyright Dareway 2021/1/11
 * @Version 1.0
 **/

class DelayTask implements Delayed {
    private static long currentTime = System.currentTimeMillis();
    protected final String taskName;
    protected final int timeCost;
    protected final long scheduleTime;

    protected static final AtomicInteger taskCount = new AtomicInteger(0);

    // 定时任务之间的启动时间间隔在1~2s之间，timeCost表示处理此任务需要的时间，本示例中为2s
    public DelayTask(String taskName, int timeCost) {
        this.taskName = taskName;
        this.timeCost = timeCost;
        taskCount.incrementAndGet();
        currentTime += 1000 + (long) (Math.random() * 1000);
        scheduleTime = currentTime;
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.scheduleTime - ((DelayTask) o).scheduleTime);
    }

    /**
     * 调用元素的getDelay方法，如果此方法返回的值小０或者等于０，则消费者线程会从队列中取出此元素，并进行处理。
     * 如果getDelay方法返回的值大于0，则消费者线程wait返回的时间值后，再从队列头部取出元素，此时元素应该已经到期。
     **/
    @Override
    public long getDelay(TimeUnit unit) {
        long expirationTime = scheduleTime - System.currentTimeMillis();
        return unit.convert(expirationTime, TimeUnit.MILLISECONDS);
    }

    public void execTask() {
        long startTime = System.currentTimeMillis();
        DateTimeFormatter df= DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss.SSS");
        System.out.println("Task " + taskName + ": schedule_start_time=" +
                //scheduleTime
                df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(scheduleTime), ZoneId.of("Asia/Shanghai")))
                + ",real start time=" +
                //        startTime
                df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(startTime), ZoneId.of("Asia/Shanghai")))
                        + ",delay=" +
                                (startTime - scheduleTime));
        //df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli((startTime - scheduleTime)), ZoneId.of("Asia/Shanghai"))));
        try {
            Thread.sleep(timeCost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DelayTaskComsumer extends Thread {
    private final BlockingQueue<DelayTask> queue;

    public DelayTaskComsumer(BlockingQueue<DelayTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        DelayTask task = null;
        try {
            while (true) {
                /**
                 * 出队
                 * poll()：如果没有元素，直接返回null；如果有元素，出队
                 * take()：如果队列空了，一直阻塞，直到队列不为空或者线程被中断-->阻塞
                 * poll(long timeout, TimeUnit unit)：如果队列不空，出队；如果队列已空且已经超时，返回null；如果队列已空且时间未超时，则进入等待，直到出现以下三种情况：
                 * 被唤醒
                 * 等待时间超时
                 * 当前线程被中断
                 * 作者：天外流星for
                 * 链接：https://www.jianshu.com/p/7b2f1fa616c6
                 * 来源：简书
                 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
                 **/
                task = queue.take();
                task.execTask();//执行任务方法
                DelayTask.taskCount.decrementAndGet();
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " finished");
        }
    }
}

public class DelayQueueExample {

    public static void main(String[] args) {

        BlockingQueue<DelayTask> queue = new DelayQueue<DelayTask>();

        for (int i = 0; i < 10; i++) {//待处理的任务数量
            try {
                /***
                 * 入队
                 * offer(E e)：如果队列没满，立即返回true； 如果队列满了，立即返回false-->不阻塞
                 * put(E e)：如果队列满了，一直阻塞，直到队列不满了或者线程被中断-->阻塞
                 * offer(E e, long timeout, TimeUnit unit)：在队尾插入一个元素,，如果队列已满，则进入等待，直到出现以下三种情况：-->阻塞
                 * 被唤醒
                 * 等待时间超时
                 * 当前线程被中断
                 * 作者：天外流星for
                 * 链接：https://www.jianshu.com/p/7b2f1fa616c6
                 * 来源：简书
                 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
                 **/
                queue.put(new DelayTask("work " + i, 2000));//执行时间2s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ThreadGroup g = new ThreadGroup("Consumers");

        for (int i = 0; i < 1; i++) {
            new Thread(g, new DelayTaskComsumer(queue)).start();
        }

        while (DelayTask.taskCount.get() > 0) {
            try {
                //线程睡眠一下，好让别的线程把任务做完
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        g.interrupt();
        System.out.println("Main thread finished");
    }
}
