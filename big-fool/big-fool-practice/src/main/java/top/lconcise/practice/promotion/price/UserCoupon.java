package top.lconcise.practice.promotion.price;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liusj
 * @date 2021/8/23
 */
@Data
public class UserCoupon {

    /***
     * 优惠券id.
     */
    private int id;

    /**
     * 领取优惠券的用户id.
     */
    private int userId;

    /**
     * 商品sku.
     */
    private String sku;

    /**
     * 优惠金额.
     */
    private BigDecimal coupon;

}
