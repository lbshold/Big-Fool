package top.lconcise.practice;

import java.util.concurrent.TimeUnit;

/**
 * @author liusj
 * @date 2020/11/25
 */
public class VolatileDemo01 {

    /**
     * volatile关键字修饰的成员变量具有的特征：
     * <p>
     * 1. 保证该成员变量在不同线程间的可见性
     * 2. 禁止对该成员变量进行重排序
     * 3. 但是volatile修饰的成员变量并不具有原子性，在并发下对它的修改是线程不安全的
     */

    private volatile static int VALUE = 0;
    private static final int LIMIT = 5;

    public static void main(String[] args) {

        new Thread(() -> {
            int value = VALUE;
            while (value < LIMIT) {
                if (value != VALUE) {
                    System.out.println("获取更新后的值：" + value);
                    value = VALUE;
                }
            }
        }, "reader").start();

        new Thread(() -> {
            int value = VALUE;
            while (value < LIMIT) {
                ++VALUE;
                //System.out.println("将VALUE的值更新为：" + ++VALUE);
                value = VALUE;
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "writer").start();
    }
}
