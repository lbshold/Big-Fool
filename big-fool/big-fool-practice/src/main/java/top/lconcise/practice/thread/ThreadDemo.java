package top.lconcise.practice.thread;

/**
 * @author liusj
 * @date 2020/12/30
 */
public class ThreadDemo {

    public static void main(String[] args){
        Consumer consumer = new Consumer();
        Producer producer = new Producer();


        Thread consumerThreadO1 = new Thread(consumer,"消费者01");
        Thread consumerThreadO2 = new Thread(consumer,"消费者02");
        Thread consumerThreadO3 = new Thread(consumer,"消费者03");

        Thread producerThread01 = new Thread(producer);


        consumerThreadO1.start();
        consumerThreadO2.start();
        consumerThreadO3.start();
        producerThread01.start();
    }
}
