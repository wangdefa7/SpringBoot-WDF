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
            executor.prestartAllCoreThreads();
            //加入阻塞队列
            DelayQueue<MyTask> queue = new DelayQueue<>();
            for (int i = 1; i <= 10; i++) {
                System.out.println("ActiveCount:" + executor.getActiveCount() + " CorePoolSize:" + executor.getCorePoolSize() + " workQueue:" + workQueue.size());
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
                System.out.println("排序时间差：" + diff);
                return diff;
            }
        }

}
