package top.lconcise.practice.singleton;

/**
 * 懒汉式(线程安全).
 *
 * @author liusj
 * @date 2020/12/14
 */
public class Singleton01 {

    private static Singleton01 instance;

    /**
     * 私有构造方法
     */
    private Singleton01() {
    }

    public static synchronized Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01();
        }
        return instance;
    }
}
