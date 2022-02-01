package com.explore.user.service.impl;

import com.explore.user.domain.User;
import com.explore.user.mapper.UserMapper;
import com.explore.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 用户服务 业务逻辑实现类
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 20:57
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getById(Long userId) {
        return userMapper.getById(userId);
    }

    @Override
    public Boolean reduction(Long userId, BigDecimal money) {

        Integer reduction = userMapper.reduction(userId, money);

        if(null != reduction && reduction > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
