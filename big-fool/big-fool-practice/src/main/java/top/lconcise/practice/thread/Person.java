package top.lconcise.practice.thread;

/**
 * 基类.
 *
 * @author liusj
 * @date 2020/12/30
 */
public abstract class Person implements Runnable {

    public static Object lock = new Object();

    public static int ticket = 0;

    /**
     * 执行方法.
     */
    public abstract void execute();
}
