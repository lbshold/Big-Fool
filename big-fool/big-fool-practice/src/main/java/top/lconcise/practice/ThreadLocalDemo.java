package top.lconcise.practice;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadLocal Demo.
 *
 * @author liusj
 * @date 2020/11/18
 */
public class ThreadLocalDemo {

    /**
     * ThreadLocal
     * <p>
     * 1.what
     * 每个线程都有自己独立的变量副本，
     * ThreadLocal作为一个容器，存在当前线程与当前线程的变量副本，
     * 而且当前线程可以在当前线程中拿到自己的变量副本，也只能拿到自己变量副本，也就保证的变量副本之间的线程隔离。
     * <p>
     *  ThreadLocal 中的主要方法
     *     public T get() {...}
     *      返回当前线程的变量副本，如果不存在，则通过initialValue()方法生成。
     *     protected T initialValue() {...}
     *      返回当前线程变量副本初始值。
     *     public void remove() {...}
     *      移除当前线程的变量副本.
     *     public void set(T value) {...}
     *      设置当前线程的变量副本。
     *
     * 2.how
     */

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return atomicInteger.getAndIncrement();
        }
    };

    public static int get() {
        return threadId.get();
    }

    private static final ThreadLocal<Integer> threadId2 = ThreadLocal.withInitial(() -> atomicInteger.getAndIncrement());

    public static void main(String[] args) {
        System.out.println(threadId.get());

        new Thread(() -> System.out.println(threadId.get())).start();
        new Thread(() -> System.out.println(threadId.get())).start();

    }
}
