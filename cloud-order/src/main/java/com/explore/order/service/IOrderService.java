package com.explore.order.service;

import com.explore.order.domain.Order;

/**
 * 订单业务逻辑接口类
 *
 * @author: HaiQing.Yu
 * @time: 2022/2/1 22:22
 */
public interface IOrderService {

    /**
     * 创建订单
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 22:10
     */
    Boolean createOrder(Order order);


    /**
     * 更新订单状态
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 22:10
     */
    Boolean updateOrderStatus(Long orderId, Integer orderStatus);

}
