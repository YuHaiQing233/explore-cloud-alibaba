package com.explore.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.explore.base.ResultResponse;
import com.explore.order.feign.IProductFeign;
import com.explore.order.feign.IUserFeign;
import com.explore.order.feign.fallback.UserBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: YuHaiQing
 * @time: 2022/2/4 21:50
 */
@RestController
@RequestMapping("/api/order")
public class InfoController {

    @Resource
    private IUserFeign userFeign;
    @Resource
    private IProductFeign productFeign;

    /**
     * 用户服务信息
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/4 21:51
     */
    @GetMapping("/user/info/{num}")
    @SentinelResource(value = "userInfo",blockHandler = "infoBlockHandler",blockHandlerClass = {UserBlockHandler.class})
    public ResultResponse userInfo(@PathVariable("num") Integer num){
        return userFeign.info(num);
    }


    /**
     * 用户服务信息
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/4 21:51
     */
    @GetMapping("/product/info")
    @SentinelResource(value = "productInfo",blockHandler = "infoBlockHandler",blockHandlerClass = {UserBlockHandler.class})
    public ResultResponse productInfo(){
        return productFeign.info();
    }

}
