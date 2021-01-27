package top.lconcise.practice.thread_producer_consumer;

import java.util.concurrent.TimeUnit;

/**
 * @author liusj
 * @date 2021/1/25
 */
public class Producer extends Person {

    public Producer(Object lock) {
        super(lock);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (ticket < 10) {
                    System.out.println("生产ticket,现在ticket数量：" + ++ticket);
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
