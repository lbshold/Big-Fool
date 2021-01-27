package top.lconcise.practice.thread_volatile;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author liusj
 * @date 2020/11/26
 */
public class VolatileDemo02 {

    /**
     * 对基本类型的赋值和修改是原子性的，而对共享变量的修改并不是原子性
     */

    private volatile static int value = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread thread01 = new Thread(() -> {
            IntStream.range(0, 500).forEach(i -> value++);
        });
        Thread thread02 = new Thread(() -> {
            IntStream.range(0, 500).forEach(i -> value++);
        });

        thread01.start();
        thread02.start();
        thread01.join();
        thread02.join();

        System.out.println(value);

        Thread thread03 = new Thread(() -> {
            IntStream.range(0, 500).forEach(i -> {
                atomicInteger.getAndIncrement();
            });
        });

        Thread thread04 = new Thread(() -> {
            IntStream.range(0, 500).forEach(i -> {
                atomicInteger.getAndIncrement();
            });
        });

        thread03.start();
        thread04.start();
        thread03.join();
        thread04.join();

        System.out.println(atomicInteger.get());
    }
}
