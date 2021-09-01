package Threads;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 */
public class Test {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            volatile int k = 0;

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    k++;
                    System.out.println(k);
                }
            }

        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();

    }

}
