package top.lconcise.practice.thread02;

import java.util.concurrent.TimeUnit;

/**
 * @author liusj
 * @date 2021/1/13
 */
public class ThreadDemo02 {

    public static void main(String[] args) {


        new Thread(()->{
            sleep("线程01");
        }).start();

        System.out.println("结束");
    }

    public static void sleep(String args){
        System.out.println(args);
    }
}
