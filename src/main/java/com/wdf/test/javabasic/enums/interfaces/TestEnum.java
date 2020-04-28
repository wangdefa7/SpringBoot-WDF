package com.wdf.test.javabasic.enums.interfaces;

/**
 * @Author WDF
 * @Description 测试枚举类
 * @Date 15:24  2020/4/28
 **/
public enum TestEnum implements TestInterface{

    MONDAY(1,"星期一"),TUSTSEDAY(2,"星期二");

    private int code;
    private String name;

    private TestEnum(int code ,String name){
        this.code=code;
        this.name=name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestEnum{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String getDay() {
        return this.getName();
    }
}
