package com.wdf.test.javabasic.duotai;


/**
 * 实现多态，继承抽象类，重写抽象方法
 */
public class BankAbstractTest {

    /**
     * 父类，业务类
     * 抽象类
     */
    static  abstract  class  Service{
        /**
         * 抽象方法
         * @param fee
         */
        public abstract void  pay(double fee);
    }

    /**
     * 子类继承抽象父类，并重写父类中的抽象方法（！！必须重写）
     */
    static class ATM extends Service{

        @Override
        public void pay(double fee) {
            System.out.println("ATM"+fee);
        }
    }

    static class Cash extends  Service{

        @Override
        public void pay(double fee){
            System.out.println("cash"+fee);
        }
    }

    public static void main(String[] args) {
        Service atm = new BankAbstractTest.ATM();//父类去实例化子类，获取子类的熟悉
        Service cash = new BankAbstractTest.Cash();

        atm.pay(10);
        cash.pay(20);
    }
}
