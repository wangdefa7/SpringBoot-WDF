package com.wdf.test.javamedium.thread.excutor;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: ExcutorpoolTest
 * @Author WDF
 * @Description 自定义线程池
 * @Date 2021/4/1 14:02
 * @Copyright Dareway 2021/4/1
 * @Version 1.0
 **/
public class ExecutorPoolTest {


        /**
         * 例子过程：
         * 初始化：核心线程数： +2  活跃线程数： +2
         * 进入线程池的任务创建过程：
         * 1： 活跃线程数： 2  核心线程数： 2  最大线程数：4  队列：0
         * 2： 活跃线程数： 2  核心线程数： 2  最大线程数：4  队列：1
         * 3： 活跃线程数： 2  核心线程数： 2  最大线程数：4  队列：2
         * 4： 活跃线程数： 3  核心线程数： 2  最大线程数：4  队列：2
         * 5： 活跃线程数： 4  核心线程数： 2  最大线程数：4  队列：2
         * 6： 活跃线程数： +1  核心线程数： 2  最大线程数：4  队列：2
         **/
        public static void main(String[] args) throws InterruptedException, IOException {
            int corePoolSize = 2;
            int maximumPoolSize = 4;
            long keepAliveTime = 10;
            TimeUnit unit = TimeUnit.SECONDS;
            //阻塞队列
            BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
            ThreadFactory threadFactory = new NameTreadFactory();
            RejectedExecutionHandler handler = new MyIgnorePolicy();
            ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                    workQueue, threadFactory, handler);
            // 预启动所有核心线程
            System.out.println("初始化-- ActiveCount:" + executor.getActiveCount() + " CorePoolSize:" + executor.getCorePoolSize() + " workQueue:" + workQueue.size());
            //预先启动所有核心线程，会导致第一个线程在用，后面的任务会直接进入队列
            //executor.prestartAllCoreThreads();
            System.out.println("初始化核心线程池-- ActiveCount:" + executor.getActiveCount() + " CorePoolSize:" + executor.getCorePoolSize() + " workQueue:" + workQueue.size());
            //加入阻塞队列
            DelayQueue<MyTask> queue = new DelayQueue<>();
            for (int i = 1; i <= 10; i++) {
                System.out.println("i = " + i +" ActiveCount:" + executor.getActiveCount() + " CorePoolSize:" + executor.getCorePoolSize() + " workQueue:" + workQueue.size());
                MyTask task = new MyTask(String.valueOf(i),i * 1000);
                queue.put(task);
                executor.execute(task);
            }

            //System.in.read(); //阻塞主线程
            for (int i = 0; i < queue.size(); i++) {
                long start = System.currentTimeMillis();
                System.out.println(i + " begin:" + start);
                MyTask task = queue.take();
                long end = System.currentTimeMillis();
                System.out.println(i +" end:" + end);
                System.out.println(i + "时间差：" + (end - start));
                System.out.println(i + "次队列执行：" + task.getName());
            }

        }

        static class NameTreadFactory implements ThreadFactory {

            private final AtomicInteger mThreadNum = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
                System.out.println(t.getName() + " has been created");
                return t;
            }
        }

        public static class MyIgnorePolicy implements RejectedExecutionHandler {

            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                doLog(r, e);
            }

            private void doLog(Runnable r, ThreadPoolExecutor e) {
                // 可做日志记录等
                System.err.println( r.toString() + " rejected");
//          System.out.println("completedTaskCount: " + e.getCompletedTaskCount());
            }
        }

        static class MyTask implements Runnable,Delayed {
            private String name;
            private long time;

            public MyTask(String name,long time) {
                this.name = name;
                this.time = System.currentTimeMillis() + time;
            }

            @Override
            public void run() {
                try {
                    System.out.println(this.toString() + " is running!");
                    Thread.sleep(3000); //让任务执行慢点
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public String getName() {
                return name;
            }

            public long getTime(){
                return time;
            }

            @Override
            public String toString() {
                return "MyTask [name=" + name + "]";
            }

            @Override
            public long getDelay(TimeUnit unit) {
                //MILLISECONDS 毫秒
                return unit.convert(time - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
            }

            @Override
            public int compareTo(Delayed o) {
                MyTask myTask = (MyTask) o;
                int diff = (int)(this.time - myTask.getTime());
                //System.out.println("排序时间差：" + diff);
                return diff;
            }
        }

}
