package top.lconcise.practice.decorator;

/**
 * @author liusj
 * @date 2021/8/20
 */
public class MainDemo {

    public static void main(String[] args) {
        Decorator decorator = new Decorator();

        CurtainDecorator curtainDecorator = new CurtainDecorator(decorator);
        curtainDecorator.decorate();
    }
}
