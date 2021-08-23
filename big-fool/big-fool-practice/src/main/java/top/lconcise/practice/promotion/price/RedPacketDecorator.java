package top.lconcise.practice.promotion.price;

import java.math.BigDecimal;

/**
 * 计算使用红包后的金额.
 *
 * @author liusj
 * @date 2021/8/23
 */
public class RedPacketDecorator extends BaseCountDecorator {

    public RedPacketDecorator(IBaseCount count) {
        super(count);
    }

    @Override
    public BigDecimal countPayMoney(OrderDetail orderDetail) {
        BigDecimal payTotalMoney = new BigDecimal(0);
        super.countPayMoney(orderDetail);
        payTotalMoney = countReadPacketMoney(orderDetail);
        return payTotalMoney;
    }

    private BigDecimal countReadPacketMoney(OrderDetail orderDetail) {
        BigDecimal redPacket = orderDetail.getMerchandise()
                .getSupportPromotions()
                .get(PromotionType.READ_PACKED)
                .getUserRedPacket()
                .getRedPacket();
        System.out.println("红包优惠金额：" + redPacket);

        orderDetail.setPayMoney(orderDetail.getPayMoney().subtract(redPacket));

        return orderDetail.getPayMoney();
    }
}
