package com.wdf.test.javabasic.thread;

public class ExtendThread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        /*方法一：继承thread类
        * 调用start方法会开启一个新的线程。
        * 调用run方法不会直接进入就绪状态。
        * */
        //myThread.run();
        myThread.start();


        /*方法二：实现runable接口
        *
        * */
        Runnable runnable = ()->{
            for (int i = 0;i < 5;i ++){
                System.out.println("num2 = "+i);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("main thread1 finish");
    }

}

class MyThread extends Thread{

//    需要并发执行的任务写到run方法中
    @Override
    public void run() {
        for (int i = 0;i < 5;i ++){
            System.out.println("num1 = "+i);
        }
    }
}