package com.explore.order.mapper;

import com.explore.order.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单 Mapper 接口类
 *
 * @author: HaiQing.Yu
 * @time: 2022/2/1 22:09
 */
@Mapper
public interface OrderMapper {

    /**
     * 创建订单
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 22:10
     */
    Integer createOrder(@Param("order") Order order);


    /**
     * 更新订单状态
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 22:10
     */
    Integer updateOrderStatus(@Param("orderId") Long orderId, @Param("orderStatus") Integer orderStatus);
}
