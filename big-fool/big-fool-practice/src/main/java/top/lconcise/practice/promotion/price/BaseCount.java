package top.lconcise.practice.promotion.price;

import java.math.BigDecimal;

/**
 * 支付基本类.
 *
 * @author liusj
 * @date 2021/8/23
 */
public class BaseCount implements IBaseCount {

    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail) {
        orderDetail.setPayMoney(orderDetail.getMerchandise().getPrice());
        System.out.println("商品元单价金额为：" + orderDetail.getPayMoney());
        return orderDetail.getPayMoney();
    }
}
