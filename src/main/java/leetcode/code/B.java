package leetcode.code;

/**
 * 测试多线程执行顺序
 */
public class B {

    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                cnn();
            }
        };
        t.run();
        System.out.print("FakeNews ");
        System.out.print("; ");
        t.start();
        System.out.print("FakeNews ");
    }
    static void cnn() {
        System.out.print("CNN ");
    }
}
