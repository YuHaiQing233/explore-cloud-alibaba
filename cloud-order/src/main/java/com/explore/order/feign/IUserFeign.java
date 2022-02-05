package com.explore.order.feign;

import com.explore.base.ResultResponse;
import com.explore.order.feign.fallback.UserFeignFallback;
import com.explore.user.domain.User;
import com.explore.user.dto.UserReductionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 调用三方接口类
 *
 * @author: HaiQing.Yu
 * @time: 2022/2/4 10:04
 */
@FeignClient(name = "cloud-user",path = "/api/user",fallback = UserFeignFallback.class)
public interface IUserFeign {

    @GetMapping(value = "/info/{num}")
    ResultResponse<String> info(@PathVariable("num") Integer num);

    @GetMapping("/find/{userId}")
    User getById(@PathVariable("userId") Long userId);

    @PostMapping("/reduction")
    Boolean reduction(@RequestBody UserReductionRequest request);
}
