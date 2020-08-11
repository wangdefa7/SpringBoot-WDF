package com.wdf.test.javabasic.classs;

/**
 * 
 * @Package: com.wdf.test.javabasic.classs
 * @ClassName: AnonInnerClassTest
 * @Description: 匿名内部类
 * @author: WDF
 * @date: 2020年8月10日 下午2:15:25
 * @version: V1.0
 */
public class AnonInnerClassTest {

	    /**
	     * 包含两个方法的HelloWorld接口
	     */
	    interface HelloWorld {
	        public void greet();
	        public void greetSomeone(String someone);
	    }

	    public void sayHello() {

	        // 1、局部类EnglishGreeting实现了HelloWorld接口
	        class EnglishGreeting implements HelloWorld {
	            String name = "world";
	            public void greet() {
	                greetSomeone("world");
	            }
	            public void greetSomeone(String someone) {
	                name = someone;
	                System.out.println("Hello " + name);
	            }
	        }

	        HelloWorld englishGreeting = new EnglishGreeting();

	        // 2、匿名类实现HelloWorld接口
	        HelloWorld frenchGreeting = new HelloWorld() {
	            String name = "tout le monde";
	            public void greet() {
	                greetSomeone("tout le monde");
	            }
	            public void greetSomeone(String someone) {
	                name = someone;
	                System.out.println("Salut " + name);
	            }
	        };

	        // 3、匿名类实现HelloWorld接口
	        HelloWorld spanishGreeting = new HelloWorld() {
	            String name = "mundo";
	            public void greet() {
	                greetSomeone("mundo");
	            }
	            public void greetSomeone(String someone) {
	                name = someone;
	                System.out.println("Hola, " + name);
	            }
	        };

	        englishGreeting.greet();
	        frenchGreeting.greetSomeone("Fred");
	        spanishGreeting.greet();
	    }

	    //public static void main(String[] args) {
	    public static void main(String... args) {//String... 与数组String[]的作用相当
	        AnonInnerClassTest myApp = new AnonInnerClassTest();
	        myApp.sayHello();
	    }
	}

