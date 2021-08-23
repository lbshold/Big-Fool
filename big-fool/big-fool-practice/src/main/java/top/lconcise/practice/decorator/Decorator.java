package top.lconcise.practice.decorator;

/**
 * 装饰基础类.
 *
 * @author liusj
 * @date 2021/8/20
 */
public class Decorator implements IDecorator {

    @Override
    public void decorate() {
        System.out.println("水电铺设、墙面粉刷。。。");
    }
}
