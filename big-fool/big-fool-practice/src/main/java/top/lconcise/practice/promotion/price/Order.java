package top.lconcise.practice.promotion.price;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 主订单.
 *
 * @author liusj
 * @date 2021/8/23
 */
@Data
public class Order {

    /**
     * 订单id .
     */
    private int id;

    /**
     * 订单号.
     */
    private String orderNo;

    /**
     * 总支付金额.
     */
    private BigDecimal totalPayMoney;

    /**
     * 详细订单列表.
     */
    private List<OrderDetail> list;
}
