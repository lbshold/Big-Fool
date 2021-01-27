package top.lconcise.practice.thread_producer_consumer;

import java.util.concurrent.TimeUnit;

/**
 * @author liusj
 * @date 2021/1/25
 */
public class Consumer extends Person {

    public Consumer(Object lock) {
        super(lock);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (ticket > 0) {
                    System.out.println("消费了，剩余ticket " + --ticket);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
