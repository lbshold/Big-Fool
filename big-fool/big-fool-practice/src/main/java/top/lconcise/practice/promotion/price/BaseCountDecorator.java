package top.lconcise.practice.promotion.price;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 计算支付金额的抽象类.
 *
 * @author liusj
 * @date 2021/8/23
 */
@Data
public abstract class BaseCountDecorator implements IBaseCount {

    private IBaseCount count;

    public BaseCountDecorator(IBaseCount count) {
        this.count = count;
    }

    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail) {
        BigDecimal payTotalMoney = new BigDecimal(0);
        if (count != null) {
            payTotalMoney = count.countPayMoney(orderDetail);
        }
        return payTotalMoney;
    }
}
