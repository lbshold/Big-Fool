package top.lconcise.practice.decorator;

/**
 * 基础装饰接口.
 *
 * 装饰器模式能够实现为对象动态添加装修功能，它是从一个对象的外部来给对象添加功能，所以有非常灵活的扩展性，
 * 我们可以在原有的代码毫无修改的前提下，为对象添加新功能。
 *
 * 除此之外，装饰器模式还能够实现对象的动态组合，借此我们可以灵活地给动态组合的对象，匹配所需要的功能。
 *
 * @author liusj
 * @date 2021/8/20
 */
public interface IDecorator {

    /**
     * 装修方法.
     */
    void decorate();
}
