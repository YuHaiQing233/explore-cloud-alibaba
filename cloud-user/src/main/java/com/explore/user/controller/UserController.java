package com.explore.user.controller;

import com.explore.user.domain.User;
import com.explore.user.service.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户 控制器类
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 18:40
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Value("${server.port}")
    private Integer port;

    @Resource
    private IUserService userService;

    @GetMapping("/info")
    public String info(){
        return "服务名称: cloud-user, 端口: " + port;
    }


    @GetMapping("/find/{userId}")
    public User getById(@PathVariable Long userId){
        return userService.getById(userId);
    }

}
