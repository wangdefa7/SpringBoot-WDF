package com.wdf.test.javamedium.syn;

/**
 * SyschronizedTest
 * 锁测试类
 */
public class Syschronized {
    static int num = 0;

    public static void main(String[] args) {
        Syschronized synS = new Syschronized();
        SynClass syn = synS.new SynClass();
        SynClassWithOut synWithout = synS.new SynClassWithOut();
        Runnable runnable = ()->{
            for (int i = 0;i < 5;i ++){
                /*try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                syn.increse();
                synWithout.increse();
               // System.out.println(" i= "+i);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }

    class SynClass {
        public synchronized void increse(){
            num++;
            System.out.println(" num= "+num);
        }
    }

    class SynClassWithOut {
        public  void increse(){
            num++;
            System.out.println(" num2= "+num);
        }
    }
}
