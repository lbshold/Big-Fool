package top.lconcise.practice.promotion.price;

import java.math.BigDecimal;

/**
 * 计算使用优惠券后的金额.
 *
 * @author liusj
 * @date 2021/8/23
 */
public class CouponDecorator extends BaseCountDecorator {

    public CouponDecorator(IBaseCount count) {
        super(count);
    }

    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail) {
        BigDecimal payTotalMoney = new BigDecimal(0);
        super.countPayMoney(orderDetail);
        payTotalMoney = countCouponPayMoney(orderDetail);
        return payTotalMoney;
    }

    private BigDecimal countCouponPayMoney(OrderDetail orderDetail) {
        BigDecimal coupon = orderDetail.getMerchandise()
                .getSupportPromotions()
                .get(PromotionType.COUPON)
                .getUserCoupon()
                .getCoupon();
        System.out.println("优惠金额：" + coupon);

        orderDetail.setPayMoney(orderDetail.getPayMoney().subtract(coupon));

        return orderDetail.getPayMoney();
    }
}
