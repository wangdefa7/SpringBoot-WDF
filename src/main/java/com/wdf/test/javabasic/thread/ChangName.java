package com.wdf.test.javabasic.thread;

/*
创建线程
 */
public class ChangName {

    public static void main(String[] args) {

        /*
        * 第一种方式：创建线程以后，直接调用setName方法
        * */
        Thread thread =new Thread();
        thread.setName("name");
        System.out.println(thread.getName());

        /*
        第二种方式：实例化一个对象，构造函数进行命令
        Thread r = new Thread(Runable r ,String name)
        * */
        Thread thread1 = new Thread(() ->{},"name");
        System.out.println( thread1.getName());

        /*
        * 第三种方式：实行自定义线程类，进行名称赋值
        * 给线程类添加构造方法
        * */
        Mythread1 mythread1  = new Mythread1("name");
        System.out.println(mythread1.getName());


    }
}

class Mythread1 extends Thread{
    public Mythread1 (){}
    public Mythread1(String name){
        //super(name);
        this.setName(name);
    }
}