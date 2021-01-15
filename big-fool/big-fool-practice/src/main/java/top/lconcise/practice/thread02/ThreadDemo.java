package top.lconcise.practice.thread02;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 创建线程的三种方法。
 *
 * @author liusj
 * @date 2021/1/12
 */
public class ThreadDemo {

    public static void main(String[] args) {

        // 1.继承Thread ，实现run方法，创建线程
        Thread thread01 = new Thread() {
            @Override
            public void run() {
                System.out.println("我是线程01");
            }
        };

        thread01.start();

        // 2.匿名实现runnable接口，创建线程
        Thread thread02 = new Thread(() -> {
            System.out.println("我是线程02");
        });

        thread02.start();


        /**
         * Callable Future
         *
         * 获取线程执行结果Future
         * 实现callable接口，返回值，通过Future阻塞获取
         * 线程池执行线程，获取线程执行结果
         */
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> atomicInteger.getAndIncrement() + 1);

        try {
            System.out.println("线程返回值：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        // FutureTask 获取线程执行结果
        FutureTask<Integer> futureTask = new FutureTask(() -> atomicInteger.getAndIncrement() + 1);

        Thread thread03 = new Thread(futureTask);
        thread03.start();

        try {
            System.out.println("线程返回值：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
