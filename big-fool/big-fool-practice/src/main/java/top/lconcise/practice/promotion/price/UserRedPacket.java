package top.lconcise.practice.promotion.price;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liusj
 * @date 2021/8/23
 */
@Data
public class UserRedPacket {
    /**
     * 红包id.
     */
    private int id;

    /**
     * 领取用户id.
     */
    private int userId;

    /**
     * 商品sku.
     */
    private String sku;

    /**
     * 领取红包金额.
     */
    private BigDecimal redPacket;
}
