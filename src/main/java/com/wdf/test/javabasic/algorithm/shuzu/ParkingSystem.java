package com.wdf.test.javabasic.algorithm.shuzu;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ParkingSystem
 * @Author WDF
 * @Description 停车系统
 * @Date 2020/10/10 15:35
 * @Copyright Dareway 2020/10/10
 * @Version 1.0
 **/
public class ParkingSystem {

    /**
     * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
     * <p>
     * 请你实现 ParkingSystem 类：
     * <p>
     * ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
     * bool addCar(int carType) 检车是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。一辆车只能停在  carType 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
     **/

    int[] park;
    public ParkingSystem(int big, int medium, int small) {
        park=new int[]{big,medium,small};
    }

    /**
        * 网上答案，非常简洁
     **/
    public boolean addCar(int carType) {
        return park[carType-1]-->0;//先用后减
    }

    /**
     * @Author WDF
     * @Description 自己根据答案写的思路
     * @Date 2020/10/10 15:53
     * @Param [carType]
     * @return boolean
     **/
    public boolean addCar2(int carType) {
        if(carType == 1 && park[0] > 0){
            park[0] --;
        }else if(carType == 2 && park[1] > 0){
            park[1] --;
        }else if(carType == 3 && park[2] > 0){
            park[2] --;
        }else{
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        ParkingSystem parkingSystem = new ParkingSystem(1,1,0);//有一个大车，一个中车，没有小车
        list.add(parkingSystem.addCar(1)); // 返回 true ，因为有 1 个空的大车位
        list.add(parkingSystem.addCar(2)); // 返回 true ，因为有 1 个空的中车位
        list.add(parkingSystem.addCar(3)); // 返回 false ，因为没有空的小车位
        list.add(parkingSystem.addCar(1)); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
        System.out.println(list);
    }

}
