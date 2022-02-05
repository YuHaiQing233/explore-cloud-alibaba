package com.explore.order.feign.fallback;

import com.explore.base.ResultResponse;
import com.explore.order.feign.IUserFeign;
import com.explore.user.domain.User;
import com.explore.user.dto.UserReductionRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务 流量控制异常处理和服务降级处理
 *
 * @author: YuHaiQing
 * @time: 2022/2/4 21:53
 */
@Component
public class UserFeignFallback implements IUserFeign {

    @Override
    public ResultResponse<String> info(@PathVariable("num") Integer num) {
        return ResultResponse.error(555,"服务降级处理,o(╥﹏╥)o");
    }

    @Override
    public User getById(Long userId) {
        return null;
    }

    @Override
    public Boolean reduction(UserReductionRequest request) {
        return null;
    }
}
