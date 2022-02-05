package com.explore.order.controller;

import com.explore.base.ResultResponse;
import com.explore.order.domain.Order;
import com.explore.order.feign.IProductFeign;
import com.explore.order.feign.IUserFeign;
import com.explore.order.service.IOrderService;
import com.explore.product.dto.ProductReductionRequest;
import com.explore.user.dto.UserReductionRequest;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.core.model.GlobalStatus;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.TransactionManagerHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单 控制器类
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 18:57
 */
@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IOrderService orderService;
    @Resource
    private IUserFeign userFeign;
    @Resource
    private IProductFeign productFeign;


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
    @GlobalTransactional(rollbackFor = Exception.class)
    public ResultResponse<Boolean> placeOrder(@RequestBody Order order){

        try {
            // 1. 创建订单
            log.info("【下单】 - 【创建订单】 - 【开始】");
            order.setOrderNo("ECA" + System.currentTimeMillis());
            order.setCreateTime(LocalDateTime.now());
            Boolean createFlag = orderService.createOrder(order);
            log.info("【下单】 - 【创建订单】 - 【结束】, 结果:{}",createFlag);
            if(!createFlag){
                this.rollback();
                return ResultResponse.error(444,"订单创建失败");
            }

            // 2. 用户扣款
            log.info("【下单】 - 【用户扣款】 - 【开始】");
            UserReductionRequest request = new UserReductionRequest();
            request.setUserId(order.getUserId());
            request.setMoney(order.getPrice().multiply(new BigDecimal(order.getQuantity())));
            Boolean reduction = userFeign.reduction(request);
            log.info("【下单】 - 【用户扣款】 - 【结束】, 结果:{}",reduction);
            if(!reduction){
                this.rollback();
                return ResultResponse.error(444,"用户扣款失败");
            }

            // 3. 产品减库存
            log.info("【下单】 - 【产品减库存】 - 【开始】");
            ProductReductionRequest productRequest = new ProductReductionRequest();
            productRequest.setProductId(order.getProductId());
            productRequest.setQuantity(order.getQuantity());
            final Boolean pFlag = productFeign.reduction(productRequest);
            log.info("【下单】 - 【产品减库存】 - 【结束】, 结果:{}",pFlag);
            if(!pFlag){
                this.rollback();
                return ResultResponse.error(444,"产品减库存失败");
            }

            // 4. 更新订单状态
            log.info("【下单】 - 【更新订单状态】 - 【开始】");
            final Boolean aBoolean = orderService.updateOrderStatus(order.getId(), Order.OrderStatus.complete.getStatus());
            log.info("【下单】 - 【更新订单状态】 - 【结束】, 结果:{}",aBoolean);
            if(!aBoolean){
                this.rollback();
                return ResultResponse.error(444,"更新订单状态失败");
            }

        } catch (Exception exception) {
            this.rollback();
            return ResultResponse.error(444,"下单业务异常");
        }

        return ResultResponse.success(Boolean.TRUE);
    }


    /**
     * 手动指定全局事务回滚业务
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/4 18:57
     */
    private void rollback(){
        try {
            log.info("【下单】 - 【业务异常】 - 【回滚全局事务】 - 【开始】");
            final String xid = RootContext.getXID();
            final GlobalStatus rollback = TransactionManagerHolder.get().rollback(xid);
            log.info("【下单】 - 【业务异常】 - 【回滚全局事务】 - 【结束】, 结果:{}",rollback.toString());
        } catch (TransactionException e) {
            log.error("【下单业务】 - 【回滚全局事务】 - 【异常】,异常:{}",e.getMessage());
        }
    }
}
