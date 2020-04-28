package com.wdf.test.javabasic.address;

/**
 * @ClassName: Person
 * @Description: 用与深浅拷贝的实体类（要实现克隆接口）
 * @Auther: WDF
 * @Date: 2020/4/2812:08
 * @Version: 1.0
 **/
public class Person implements Cloneable{

    public Person(){}

    public Person(int i,String name) {
        this.i =i;
        this.name=name;
    }

    private int i;
    private String name;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * @Author WDF
     * @Description 实现浅拷贝
     * @Date 13:05  2020/4/28
     * @Param
     * @return
     **/
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }
}
