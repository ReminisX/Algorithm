package Threads;

/**
 * @author l
 */
public class TestRunnable {
    public static void main(String[] args) {
        Runnable target;
        Runnable R = new Runnables();
        Thread r1 = new Thread(R);
        Thread r2 = new Thread(R);
        r1.run();
        r2.run();
    }
}

class Runnables implements Runnable{
    public int k = 0;
    @Override
    public void run() {
        k++;
        System.out.println("线程" + Thread.currentThread().getName() + "运行中");
        System.out.println("the value of k is: " + k);
    }
}