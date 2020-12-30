package top.lconcise.practice.thread;

import java.util.concurrent.TimeUnit;

/**
 * 消费者.
 *
 * @author liusj
 * @date 2020/12/30
 */
public class Consumer extends Person {

    @Override
    public void execute() {
        synchronized (lock) {
            while (true) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " 消费中，当前ticket : " + ticket);
                    ticket--;
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (ticket == 0) {
                        System.out.println("消费品清空，待生产！");
                        lock.notifyAll();
                    }
                } else { // 条件不满足就等待
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        execute();
    }
}
