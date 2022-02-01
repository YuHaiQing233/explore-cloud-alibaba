package com.explore.order.controller;

import com.explore.order.domain.Order;
import com.explore.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 订单 控制器类
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 18:57
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IOrderService orderService;

    @GetMapping("/info")
    public String Info(){
        return "服务名称: cloud-order, 服务端口: " + port;
    }


    /**
     * 下单业务
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 22:25
     */
    @PostMapping("/placeOrder")
    public Boolean placeOrder(@RequestBody Order order){

        // 1. 创建订单
        Boolean createFlag = orderService.createOrder(order);

        // 2. 用户扣款

        // 3. 产品减库存

        // 4. 更新订单状态

        return null;
    }

}
