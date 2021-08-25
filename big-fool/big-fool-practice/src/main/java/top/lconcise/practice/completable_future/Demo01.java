package top.lconcise.practice.completable_future;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author liusj
 * @date 2021/1/28
 */
public class Demo01 {

    public static void main(String[] args) throws Exception {

        CompletableFuture<BigDecimal> future = CompletableFuture.supplyAsync(Demo01::fetchPrice);

        future.thenAccept(price -> System.out.println("价格：" + price));

        System.out.println("==");

        TimeUnit.SECONDS.sleep(2);

    }

    static BigDecimal fetchPrice() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new BigDecimal(Math.random() * 20).add(new BigDecimal(5));
    }
}
