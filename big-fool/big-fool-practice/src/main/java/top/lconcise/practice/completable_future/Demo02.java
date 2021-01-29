package top.lconcise.practice.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author liusj
 * @date 2021/1/28
 */
public class Demo02 {

    public static void main(String[] args) throws Exception{
        CompletableFuture<String> future = CompletableFuture.supplyAsync(Demo02::findCodeById);

        CompletableFuture<String> future02 = future.thenApplyAsync(code -> findNameByCode(code));

        future02.thenAccept(result->System.out.println(result));

        System.out.println("==");
        TimeUnit.SECONDS.sleep(3);
    }

    static String findCodeById() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "007";
    }

    static String findNameByCode(String code) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "邓超";
    }
}
