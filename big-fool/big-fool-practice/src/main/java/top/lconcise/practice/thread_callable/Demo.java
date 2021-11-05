package top.lconcise.practice.thread_callable;

import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @author liusj
 * @date 2021/1/25
 */
public class Demo {

    /**
     * 分工、协作
     * T1：洗水壶(1分钟)、烧开水(15分钟)、泡茶
     *     T1 要拿到T2的劳动结果
     *     T1 返回结果上茶
     *
     * T2：洗茶壶(1分钟)、洗茶杯(1分钟)、拿茶叶(1分钟)
     *      T2 返回结果是茶叶
     *
     * 解题思路
     *    1.返回结果Callable
     *    2. T1 的泡茶要等T2拿到茶叶， future.get()
     */
    public static void main(String[] args) throws Exception{

        System.out.println(DigestUtils.md5DigestAsHex(("ZHFH_" + "15114818612").getBytes()));

//        FutureTask futureTask02 = new FutureTask(new MyTask02());
//        FutureTask futureTask01 = new FutureTask(new MyTask01(futureTask02));
//
//        new Thread(futureTask01).start();
//        new Thread(futureTask02).start();

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<String> future02 = executorService.submit(new MyTask02());
//        Future<String> future01 = executorService.submit(new MyTask01(future02));
//
//        System.out.println(future01.get());

//        executorService.shutdown();
    }
}

//class MyTask01 implements Callable<String> {
//
//    private Future<String> futureTask;
//
//    public MyTask01(Future futureTask) {
//        this.futureTask = futureTask;
//    }
//
//    @Override
//    public String call() throws Exception {
//        System.out.println("洗水壶");
//        TimeUnit.SECONDS.sleep(1);
//
//        System.out.println("烧开水");
//        TimeUnit.SECONDS.sleep(15);
//
//        String tea = futureTask.get();
//
//        System.out.println("泡茶");
//        TimeUnit.SECONDS.sleep(3);
//
//        return "上茶" + tea;
//    }
//}
//
//class MyTask02 implements Callable<String>{
//
//    @Override
//    public String call() throws Exception {
//
//        System.out.println("洗茶壶");
//        TimeUnit.SECONDS.sleep(1);
//
//        System.out.println("洗茶杯");
//        TimeUnit.SECONDS.sleep(1);
//
//        System.out.println("拿茶叶");
//        TimeUnit.SECONDS.sleep(1);
//
//        return "龙井茶";
//    }
//}
