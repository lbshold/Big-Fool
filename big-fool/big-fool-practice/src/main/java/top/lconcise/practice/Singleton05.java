package top.lconcise.practice;

/**
 * 枚举.
 *
 * @author liusj
 * @date 2020/12/14
 */
public enum Singleton05 {

    INSTANCE;

    public static Singleton05 getInstance() {
        return INSTANCE;
    }
}
