package top.lconcise.practice;

import java.util.concurrent.TimeUnit;

/**
 * @author liusj
 * @date 2020/11/25
 */
public class VolatileDemo01 {

    /**
     * 并发编程的三个概念：原子性、可见性、有序性
     *
     * 原子性：即一个操作或者多个操作 要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行。
     * 可见性：可见性是指当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值。
     * 有序性：即程序执行的顺序按照代码的先后顺序执行。(可能发生指令重排导致代码执行先后顺序发生变化)
     *
     * Java内存模型
     * 1. Java内存模型规定所有的变量都是存在主存中，每个线程都有自己的工作内存。
     * 2. 线程对变量的所有操作都必须在工作内存中进行，而不能直接对主存操作。
     * 3. 并且每个线程不能访问其他线程的内存。
     *
     * Java 原子性
     *   对基本类型的变量的读取和赋值操作都是原子性操作，这些操作不能被中断，要么执行，要么不执行
     * Java 可见性
     *   Java提供了Volatile 关键字来保证可见性
     *   当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
     *   通过synchronized和Lock也能够保证可见性，synchronized和Lock能保证同一时刻只有一个线程获取锁然后执行同步代码，
     *   并且在释放锁之前会将对变量的修改刷新到主存当中。因此可以保证可见性。
     * Java 有序性
     * 在Java内存模型中，允许编译器和处理器对指令进行重排序，但是重排序过程不会影响到单线程程序的执行，却会影响到多线程并发执行的正确性。
     *
     * 在Java里面，可以通过volatile关键字来保证一定的“有序性”。
     * 另外可以通过synchronized和Lock来保证有序性，很显然，synchronized和Lock保证每个时刻是有一个线程执行同步代码，相当于是让线程顺序执行同步代码，自然就保证了有序性。
     *
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
