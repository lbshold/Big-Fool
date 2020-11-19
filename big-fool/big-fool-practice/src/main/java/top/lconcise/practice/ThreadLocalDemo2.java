package top.lconcise.practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liusj
 * @date 2020/11/18
 */
public class ThreadLocalDemo2 {

    /**
     * 为什么要这么做呢？
     *  SimpleDateFormat 是线程不安全的，使用ThreadLocal 保证了线程安全。
     *  ThreadLocal对象使用static修饰，ThreadLocal无法解决共享对象的更新问题。
     *      说明：这个变量是针对一个线程内所有操作共享的，所以设置为静态变量，所有此类实例共享此静态变量，
     *  也就是说在类第一次被使用时装载，只分配一块存储空间，所有此类的对象(只要是这个线程内定义的)都可
     *  以操控这个变量。
     */
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };


    public static void main(String[] args){
        System.out.println(df.get().format(new Date()));
        System.out.println(df.get().format(new Date()));
        System.out.println(df.get().format(new Date()));


        // Random  ThreadLocalRandom
        System.out.println(new Random().nextInt(10));
        System.out.println(ThreadLocalRandom.current().nextInt(10));
    }
}
