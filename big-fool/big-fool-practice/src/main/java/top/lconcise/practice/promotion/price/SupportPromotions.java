package top.lconcise.practice.promotion.price;

import lombok.Data;

/**
 * 促销类型。
 *
 * @author liusj
 * @date 2021/8/23
 */
@Data
public class SupportPromotions implements Cloneable {

    /**
     * 该商品促销的id.
     */
    private int id;

    /**
     * 促销类型.
     */
    private PromotionType promotionType;

    /**
     * 优先级.
     */
    private int priority;

    /**
     * 用户领取该商品的优惠券.
     */
    private UserCoupon userCoupon;

    /**
     * 用户领取该商品的红包.
     */
    private UserRedPacket userRedPacket;

    @Override
    protected SupportPromotions clone() throws CloneNotSupportedException {
        return (SupportPromotions)super.clone();
    }
}
