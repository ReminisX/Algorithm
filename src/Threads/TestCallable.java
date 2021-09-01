package Threads;

import java.util.concurrent.*;

/**
 * @author l
 */
public class TestCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Callable callable = new MyCallable();
        FutureTask task = new FutureTask(callable);
        new Thread(task).start();
        System.out.println(task.get());
        Thread.sleep(10);
        //等待线程执行结束
        //task.get() 获取call()的返回值。若调用时call()方法未返回，则阻塞线程等待返回值
        //get的传入参数为等待时间，超时抛出超时异常；传入参数为空时，则不设超时，一直等待
        System.out.println(task.get(100L, TimeUnit.MILLISECONDS));
    }
}

class MyCallable implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("通过实现Callable，线程号:" + Thread.currentThread().getName());
        return 10;
    }
}