package top.lconcise.practice.demo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author liusj
 * @date 2021/9/10
 */
public class SynchronizedDemo {

    /**
     * 同步方法.
     */
    public synchronized void doSth(){
        System.out.println("Hello World");
    }

    /**
     * 同步代码块.
     */
    public void doSth02(){
        synchronized (new SynchronizedDemo()){
            System.out.println("Hello World");
        }
    }
}
