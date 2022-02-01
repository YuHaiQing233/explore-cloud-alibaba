package com.explore.order.service.impl;

import com.explore.order.domain.Order;
import com.explore.order.mapper.OrderMapper;
import com.explore.order.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单 业务逻辑 实现类
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 22:23
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;


    @Override
    public Boolean createOrder(Order order) {

        Integer row = orderMapper.createOrder(order);

        if(null != row && row > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean updateOrderStatus(Long orderId, Integer orderStatus) {

        Integer row = orderMapper.updateOrderStatus(orderId, orderStatus);

        if(null != row && row > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
