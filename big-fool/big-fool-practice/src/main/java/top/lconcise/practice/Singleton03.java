package top.lconcise.practice;

/**
 * 双检索.
 *
 * @author liusj
 * @date 2020/12/14
 */
public class Singleton03 {

    private static volatile Singleton03 instance;

    private Singleton03() {
    }

    public static Singleton03 getInstance() {
        if (instance == null) {
            synchronized (Singleton03.class) {
                if (instance == null) {
                    instance = new Singleton03();
                }
            }
        }
        return instance;
    }
}
