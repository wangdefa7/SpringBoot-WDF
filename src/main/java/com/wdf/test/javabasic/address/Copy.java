package com.wdf.test.javabasic.address;

/**
 * @ClassName: Copy
 * @Description: 深拷贝和浅拷贝
 *  很详细的文档： https://blog.csdn.net/zhangjg_blog/article/details/18369201
 * @Auther: WDF
 * @Date: 2020/4/2811:39
 * @Version: 1.0
 **/
public class Copy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person(23, "zhang");
        Person p1 = (Person) p.clone();

        String result = p.getName() == p1.getName() ? "clone是浅拷贝的" : "clone是深拷贝的";

        System.out.println(result);
    }
}
