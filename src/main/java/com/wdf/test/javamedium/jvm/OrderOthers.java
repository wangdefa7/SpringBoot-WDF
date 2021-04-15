package com.wdf.test.javamedium.jvm;

/**
 * @ClassName: OrderOthers
 * @Author WDF
 * @Description //指令重排
 * @Date 2021/3/30 13:26
 * @Copyright Dareway 2021/3/30
 * @Version 1.0
 **/
public class OrderOthers {

        //变量1
        private static  int a=0;
        //变量2
        private  static boolean flag=false;
        public static void main(String[] args) {
            for(int i=0;i<100;i++) {
                a = 0;
                flag = false;
                //修改数据
                Thread t1 = new Thread(() -> {
                    a = 1;
                    flag = true;
                });
                //输出数据
                Thread t2 = new Thread(() -> {
                    if (flag) {
                        a *= 1;
                    }
                    //指令重排
                    if (a == 0) {
                        System.out.println("happendbefore a->" + a);
                    }
                });

                t1.start();
                t2.start();

                /***
                 * 此代码中当循环运行，给两个线程先后加了join线程合并，t1先执行完，
                 * 在执行t2，t1线程为修改数据，在修改a1，并返回之前，
                 * cpu等不了了，就开始执行t2，此时a的值还是为0.所以执行了if（a0）在输出之前，
                 * a数据已经改好了为1，所以此时输出happendbefore a->1。这就是一个典型得指令重排。
                 * ————————————————
                 **/
                try {//线程插队//让t1先运行结束
                    //t1.join();
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


