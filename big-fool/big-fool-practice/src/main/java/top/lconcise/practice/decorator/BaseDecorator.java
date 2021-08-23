package top.lconcise.practice.decorator;

/**
 * 基本装饰类.
 *
 * @author liusj
 * @date 2021/8/20
 */
public abstract class BaseDecorator implements IDecorator {

    private IDecorator decorator;

    public BaseDecorator(IDecorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public void decorate() {
        if (decorator != null) {
            decorator.decorate();
        }
    }
}
