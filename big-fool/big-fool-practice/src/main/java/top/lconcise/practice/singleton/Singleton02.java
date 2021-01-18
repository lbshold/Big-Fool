package top.lconcise.practice.singleton;

/**
 * 饿汉式.
 *
 * @author liusj
 * @date 2020/12/14
 */
public class Singleton02 {

    private static Singleton02 instance = new Singleton02();

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        return instance;
    }
}
