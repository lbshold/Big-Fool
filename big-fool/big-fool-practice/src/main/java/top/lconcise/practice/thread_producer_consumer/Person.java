package top.lconcise.practice.thread_producer_consumer;

/**
 * @author liusj
 * @date 2021/1/25
 */
public abstract class Person implements Runnable{

    public Object lock;

    protected static int ticket;

    public Person(Object lock) {
        this.lock = lock;
    }
}
