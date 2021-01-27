package top.lconcise.practice.thread_volatile;

/**
 * @author liusj
 * @date 2020/11/27
 */
public class VolatileDemo03 {

    /**
     * 虽然加了同步锁，但是多线程下并不是线程安全的。
     *
     * instance = new VolatileDemo03()在实际执行的时候会被拆分为以下三个步骤:
     * 1. 分配存储VolatileDemo03对象的内存空间
     * 2. 将instance指向刚刚分配的内存空间
     * 3. 初始化VolatileDemo03对象
     */

    // 私有化构造方法
    private VolatileDemo03() {
    }

    // 单例对象
    private static VolatileDemo03 instance = null;

    public static VolatileDemo03 getInstance() {
        if (instance == null) { // 双检索
            synchronized (VolatileDemo03.class) { // 同步锁
                instance = new VolatileDemo03();
            }
        }
        return instance;
    }
}
