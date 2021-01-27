package top.lconcise.practice.thread_producer_consumer;

/**
 * @author liusj
 * @date 2021/1/25
 */
public class Demo03 {

    public static void main(String[] args){

        Object lock = new Object();

        Consumer consumer = new Consumer(lock);
        Producer producer = new Producer(lock);

        Thread consumer01 = new Thread(consumer,"消费者01");
        Thread consumer02 = new Thread(consumer,"消费者02");
        Thread consumer03 = new Thread(consumer,"消费者03");
        Thread consumer04 = new Thread(consumer,"消费者04");
        Thread producer01 = new Thread(producer,"生产者01");

        consumer01.start();
        consumer02.start();
        consumer03.start();
        consumer04.start();
        producer01.start();

    }
}
