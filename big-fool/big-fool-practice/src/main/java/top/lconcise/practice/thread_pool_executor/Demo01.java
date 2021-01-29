package top.lconcise.practice.thread_pool_executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liusj
 * @date 2021/1/29
 */
public class Demo01 {

    public static void main(String[] args) {
        // 核心线程1，最大线程2，队列1
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardPolicy());
        System.out.println("===  线程池创建完成");

        threadPoolExecutor.execute(() -> sleep("任务一"));
        threadPoolExecutor.execute(() -> sleep("任务二"));
        threadPoolExecutor.execute(() -> sleep("任务三"));
        threadPoolExecutor.execute(() -> sleep("任务四"));

        threadPoolExecutor.shutdownNow();
//        int activeCount = -1;
//        int queueSize = -1;
//        while (true) {
//            if (activeCount != threadPoolExecutor.getActiveCount() || queueSize != threadPoolExecutor.getQueue().size()) {
//                System.out.println("===  活跃线程数：" + threadPoolExecutor.getActiveCount());
//                System.out.println("===  核心线程数：" + threadPoolExecutor.getCorePoolSize());
//                System.out.println("===  队列线程数：" + threadPoolExecutor.getQueue().size());
//                System.out.println("===  最大线程数：" + threadPoolExecutor.getMaximumPoolSize());
//                System.out.println("---------------------------");
//                activeCount = threadPoolExecutor.getActiveCount();
//                queueSize = threadPoolExecutor.getQueue().size();
//            }
//        }


    }

    static void sleep(String name) {
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println(Thread.currentThread().getName() + " 睡眠10秒 " + name);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "执行过程中线程被打断");
        }
    }
}
