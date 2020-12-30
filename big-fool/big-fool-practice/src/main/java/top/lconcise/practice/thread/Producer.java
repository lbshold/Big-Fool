package top.lconcise.practice.thread;

import java.util.concurrent.TimeUnit;

/**
 * 生产者.
 *
 * @author liusj
 * @date 2020/12/30
 */
public class Producer extends Person {

    @Override
    public void execute() {
        synchronized (lock) {
            while (true) {
                if (ticket == 0) {
                    while (ticket < 10) {
                        System.out.println(Thread.currentThread().getName()+" 生产中，当前ticket : " + ticket);
                        ticket++;
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("生产完毕！");

                    lock.notifyAll();

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
