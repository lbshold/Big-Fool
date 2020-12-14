package top.lconcise.practice;

/**
 * 静态内部类.
 *
 * @author liusj
 * @date 2020/12/14
 */
public class Singleton04 {

    private static Singleton04 instance;

    private Singleton04() {
    }

    public static Singleton04 getInstance() {
        return Inner.INSTANCE;
    }

    /**
     * 静态内部类.
     * 内部类只有在getInstance()方法第一次调用的时候才会加载(实现了延迟加载的效果)，
     * 而且其加载过程是线程安全的(实现线程安全)。内部类加载的时候只实例化了一次instance
     */
    private static class Inner {
        private static final Singleton04 INSTANCE = new Singleton04();
    }
}
