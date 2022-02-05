package com.explore.order.feign.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.explore.base.ResultResponse;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务 流量控制处理
 *
 * @author: YuHaiQing
 * @time: 2022/2/4 22:27
 */
public class UserBlockHandler {

    /**
     * 用户服务流量控制
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/4 22:28
     */
    public static ResultResponse<String> infoBlockHandler(@PathVariable("num") Integer num, BlockException exception) {
        return ResultResponse.error(555,"流量控制处理,╮(╯▽╰)╭");
    }

}
