package top.lconcise.practice.thread02;

import java.util.concurrent.*;

/**
 * @author liusj
 * @date 2021/1/18
 */
public class CallableDemo02 {

    /**
     * 分工、协作
     * T1：洗水壶(1分钟)、烧开水(15分钟)、泡茶
     * T2：洗茶壶(1分钟)、洗茶杯(1分钟)、拿茶叶(1分钟)
     */
    public static void main(String[] args) {
        FutureTask futureTask01 = new FutureTask(new Task02());
        FutureTask<String> futureTask02 = new FutureTask(new Task01(futureTask01));

        Thread thread = new Thread(futureTask01);
        Thread thread02 = new Thread(futureTask02);

        thread.start();
        thread02.start();

        String result = null;
        try {
            result = futureTask02.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}

/**
 * T1：洗水壶(1分钟)、烧开水(15分钟)、泡茶
 */
class Task01 implements Callable<String> {

    private FutureTask<String> futureTask;

    public Task01(FutureTask futureTask) {
        this.futureTask = futureTask;
    }

    @Override
    public String call() throws Exception {

        System.out.println("T1 洗水壶。。。");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("T1 烧开水。。。");
        TimeUnit.SECONDS.sleep(15);
        System.out.println("T1 水烧开了。。。");

        String str = futureTask.get();
        System.out.println("T1 拿到茶叶");

        System.out.println("T1 泡茶。。。");
        return "上茶" + str;
    }
}

/**
 * T2：洗茶壶(1分钟)、洗茶杯(1分钟)、拿茶叶(1分钟)
 */
class Task02 implements Callable<String> {

    @Override
    public String call() throws Exception {

        System.out.println("T2 洗茶壶...");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("T2 洗茶杯...");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("T2 拿茶叶...");
        TimeUnit.SECONDS.sleep(1);

        return "龙井";
    }
}

