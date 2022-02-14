package top.lconcise.practice.promotion.price;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author liusj
 * @date 2021/8/23
 */
public class MainDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
//        Order order = new Order();
//        init(order);
//
//        for (OrderDetail orderDetail : order.getList()) {
//            BigDecimal payMoney = PromotionFactory.getPayMoney(orderDetail);
//            orderDetail.setPayMoney(payMoney);
//            System.out.println("最终支付金额：" + orderDetail.getPayMoney());
//        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();
        list.remove(1);
        Iterator<Integer> iterator02 = list.iterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.out.println();

        while (iterator02.hasNext()){
            System.out.print(iterator02.next());
        }
        System.out.println();
    }

    private static void init(Order order) throws CloneNotSupportedException {
        Map<PromotionType, SupportPromotions> supportPromotionsMap = new HashMap<>(16);

        SupportPromotions couponPromotions = new SupportPromotions();
        couponPromotions.setPromotionType(PromotionType.COUPON);
        couponPromotions.setPriority(1);

        UserCoupon userCoupon = new UserCoupon();
        userCoupon.setCoupon(new BigDecimal(3));
        userCoupon.setSku("aaa");
        userCoupon.setUserId(1);

        couponPromotions.setUserCoupon(userCoupon);

        supportPromotionsMap.put(PromotionType.COUPON, couponPromotions);

        SupportPromotions redPacketPromotions = couponPromotions.clone();
        redPacketPromotions.setPromotionType(PromotionType.READ_PACKED);
        redPacketPromotions.setPriority(2);

        UserRedPacket userRedPacket = new UserRedPacket();
        userRedPacket.setId(1);
        userRedPacket.setRedPacket(new BigDecimal(10));
        userRedPacket.setSku("aaa");
        userRedPacket.setUserId(11);

        redPacketPromotions.setUserRedPacket(userRedPacket);
        supportPromotionsMap.put(PromotionType.READ_PACKED, redPacketPromotions);


        Merchandise merchandise = new Merchandise();
        merchandise.setSku("aaa");
        merchandise.setName("华为手机");
        merchandise.setPrice(new BigDecimal(20));
        merchandise.setSupportPromotions(supportPromotionsMap);

        List<OrderDetail> orderDetails = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(1);
        orderDetail.setOrderId(1111);
        orderDetail.setMerchandise(merchandise);

        orderDetails.add(orderDetail);
        order.setList(orderDetails);
    }
}
