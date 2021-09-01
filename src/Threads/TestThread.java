package Threads;

/**
 * @author l
 */
class MyThread extends Thread{
    public int k = 0;
    @Override
    public void run(){
        k++;
        System.out.println("线程" + currentThread().getName() + "运行中");
        System.out.println("the value of k is: " + k);
    }
}

/**
 * @author l
 */
public class TestThread {

    public static void main(String[] args) {
        Thread a = new MyThread();
        Thread b = new MyThread();
        a.start();
        b.start();
    }
}
