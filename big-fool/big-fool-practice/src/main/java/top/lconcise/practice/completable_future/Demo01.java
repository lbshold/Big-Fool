package top.lconcise.practice.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author liusj
 * @date 2021/1/28
 */
public class Demo01 {

    public static void main(String[] args) throws Exception {

        CompletableFuture<Double> future = CompletableFuture.supplyAsync(Demo01::fetchPrice);

        future.thenAccept(price -> System.out.println("价格：" + price));

        System.out.println("==");

        TimeUnit.SECONDS.sleep(2);

    }

    static Double fetchPrice() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return 5 + Math.random() * 20;
    }
}
