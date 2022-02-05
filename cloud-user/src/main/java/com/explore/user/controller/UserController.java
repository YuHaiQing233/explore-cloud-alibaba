package com.explore.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.explore.base.ResultResponse;
import com.explore.user.domain.User;
import com.explore.user.dto.UserReductionRequest;
import com.explore.user.service.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户 控制器类
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 18:40
 */
@RefreshScope
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Value("${server.port}")
    private Integer port;

    @Resource
    private IUserService userService;

    @GetMapping("/info/{num}")
    @SentinelResource(value = "info",blockHandler = "infoBlockHandler",fallback = "infoFallback")
    public ResultResponse info(@PathVariable("num") Integer num){

        if(num > 3){
            throw new RuntimeException();
        }

        return ResultResponse.success("服务名称: cloud-user, 端口: " + port);
    }


    @GetMapping("/find/{userId}")
    public User getById(@PathVariable Long userId){
        return userService.getById(userId);
    }

    /**
     * 扣款
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 20:57
     */
    @PostMapping("/reduction")
    @Transactional(rollbackFor = Exception.class)
    public Boolean reduction(@RequestBody UserReductionRequest request){
        return userService.reduction(request.getUserId(), request.getMoney());
    }


    /**
     * 流量控制 处理逻辑
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/4 21:16
     */
    public ResultResponse infoBlockHandler(BlockException exception){
        return ResultResponse.error(555,"糟糕,服务器被限流了o(╥﹏╥)o");
    }


    /**
     * 服务降级 业务逻辑处理
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/4 21:30
     */
    public ResultResponse infoFallback(@PathVariable("num") Integer num,Throwable th){
        return ResultResponse.error(555,"服务繁忙,请稍后重试,┓( ´∀` )┏");
    }

}
