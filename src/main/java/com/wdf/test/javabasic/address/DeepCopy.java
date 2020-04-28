package com.wdf.test.javabasic.address;

/**
 * @ClassName: DeepCopy
 * @Description: 深度拷贝
 * @Auther: WDF
 * @Date: 2020/4/2814:06
 * @Version: 1.0
 **/
public class DeepCopy {

    static class Body implements Cloneable{
        public Head head;

        public Body() {}

        public Body(Head head) {
            this.head = head;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    static class Head /*implements Cloneable*/{
        public  DeepCopy face;

        public Head() {}
        public Head(DeepCopy face){this.face = face;}

    }
    public static void main(String[] args) throws CloneNotSupportedException {

        Body body = new Body(new Head());
        Body body1 = (Body) body.clone();
        System.out.println("body == body1 : " + (body == body1) );
        System.out.println("body.head == body1.head : " +  (body.head == body1.head));
    }
}
