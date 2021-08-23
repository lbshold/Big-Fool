package top.lconcise.practice.promotion.price;

import lombok.Data;

import javax.naming.ldap.PagedResultsControl;
import java.math.BigDecimal;

/**
 *  详细订单.
 *
 * @author liusj
 * @date 2021/8/23
 */
@Data
public class OrderDetail {

    /**
     * 订单ID.
     */
    private int id;

    /**
     * 订单号.
     */
    private int orderId;

    /**
     * 商品详情.
     */
    private Merchandise merchandise;

    /**
     * 支付金额.
     */
    private BigDecimal payMoney;
}
