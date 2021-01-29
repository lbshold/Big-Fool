package top.lconcise.practice.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author liusj
 * @date 2021/1/28
 */
public class Demo03 {

    public static void main(String[] args) {
        CompletableFuture<String> future01 = CompletableFuture.supplyAsync(() -> {
            return buyCar("雷克萨斯", "高新4S店");
        });

        CompletableFuture<String> future02 = CompletableFuture.supplyAsync(() -> {
            return buyCar("雷克萨斯", "未央4s店");
        });

        CompletableFuture<Object> carFuture = CompletableFuture.anyOf(future01, future02);
        
    }

    static String buyCar(String carName, String shop) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("在" + shop + "购买小汽车");

        return carName;
    }

    static String driveCar(String car, String path) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("从那条路回家：" + path);
        return "开着" + car + "回家";
    }
}
