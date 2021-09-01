package Threads;

/**
 * @author l
 */
public class WaitVsSleep {
    public static void main(String[] args) {

        Mthread sleep = new Mthread();
        sleep.start();
        sleep.interrupt();


    }
}

class Mwait{
    int k = 0;
    public void run(){
        k++;
        System.out.println("wait:" + k);
    }

}

class Mthread extends Thread {
    int k = 0;
    @Override
    public void run() {
        Mwait wait = new Mwait();
        try {
            synchronized (wait) {
                wait.wait();
            }
        } catch (InterruptedException e) {
            System.out.println("wait error");
        }
        for (int i = 0; i < 5; i++) {
            k++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("sleep error");
            }
            System.out.println("sleep:" + k);
        }

        wait.notify();

    }
}
