package top.lconcise.practice.promotion.price;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 商品.
 *
 * @author liusj
 * @date 2021/8/23
 */
@Data
public class Merchandise {

    /**
     * 商品sku.
     */
    private String sku;

    /**
     * 商品名称.
     */
    private String name;

    /**
     * 商品单价.
     */
    private BigDecimal price;

    /**
     * 支持促销类型.
     */
    private Map<PromotionType,SupportPromotions> supportPromotions;

}
