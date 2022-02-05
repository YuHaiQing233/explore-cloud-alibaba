package com.explore.order.feign.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.explore.base.ResultResponse;
import com.explore.order.feign.IProductFeign;
import com.explore.product.dto.ProductReductionRequest;
import org.springframework.stereotype.Component;

/**
 * 产品服务 流量控制处理,服务降级处理
 *
 * @author: YuHaiQing
 * @time: 2022/2/4 21:57
 */
@Component
public class ProductFeignFallback implements IProductFeign {
    @Override
    public ResultResponse<String> info() {
        return ResultResponse.error(555,"服务降级处理,o(╥﹏╥)o");
    }

    public ResultResponse<String> infoBlockHandler(BlockException exception) {
        return ResultResponse.error(555,"流量控制处理,╮(╯▽╰)╭");
    }

    @Override
    public Boolean reduction(ProductReductionRequest request) {
        return null;
    }
}
