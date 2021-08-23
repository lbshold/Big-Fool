package top.lconcise.practice.decorator;

/**
 * 窗帘装饰类.
 *
 * @author liusj
 * @date 2021/8/20
 */
public class CurtainDecorator extends BaseDecorator {

    public CurtainDecorator(IDecorator decorator) {
        super(decorator);
    }

    @Override
    public void decorate() {
        System.out.println("窗帘装饰。。。");
        super.decorate();
    }
}
