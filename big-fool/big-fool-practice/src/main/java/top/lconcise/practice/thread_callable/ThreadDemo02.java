package top.lconcise.practice.thread_callable;

import java.util.concurrent.*;

/**
 * @author liusj
 * @date 2021/1/25
 */
public class ThreadDemo02 {

    public static void main(String[] args) throws Exception {

        /**
         *  1. 洗水壶、烧开水
         *  2. 洗茶壶、洗茶杯、拿茶叶
         *  3. 泡茶
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Thread::new,
                new ThreadPoolExecutor.AbortPolicy());

        CountDownLatch downLatch = new CountDownLatch(2);

        threadPoolExecutor.execute(() -> {
            System.out.println("洗水壶");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("烧水");
            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            downLatch.countDown();
        });

        Future<String> submit = threadPoolExecutor.submit(() -> {
            System.out.println("洗茶壶");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("洗茶杯");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("拿茶叶");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            downLatch.countDown();
        },"龙井茶");


        downLatch.await();
        System.out.println("泡茶");
        System.out.println("上茶：" + submit.get());

    }
}
