package top.lconcise.practice.promotion.price;

import java.math.BigDecimal;

/**
 * 计算支付金额接口类.
 *
 * @author liusj
 * @date 2021/8/23
 */
public interface IBaseCount {

    BigDecimal countPayMoney(OrderDetail orderDetail);
}
