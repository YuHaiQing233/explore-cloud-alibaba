package com.explore.user.service;

import com.explore.user.domain.User;

import java.math.BigDecimal;

/**
 * 用户 业务逻辑接口类
 *
 * @author: HaiQing.Yu
 * @time: 2022/2/1 20:55
 */
public interface IUserService {

    /**
     * 根据用户Id查询用户信息
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 20:56
     */
    User getById(Long userId);

    /**
     * 扣款
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 20:57
     */
    Boolean reduction(Long userId, BigDecimal money);

}
