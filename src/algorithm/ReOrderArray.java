package algorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class ReOrderArray {

    private static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            ++x;
        });
        t1.start();
        t1.join();
        System.gc();
        System.out.println(x);
    }

}
