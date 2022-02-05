package com.explore.order.feign;

import com.explore.base.ResultResponse;
import com.explore.order.feign.fallback.ProductFeignFallback;
import com.explore.product.dto.ProductReductionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 产品接口类
 *
 * @author: HaiQing.Yu
 * @time: 2022/2/4 10:16
 */
@FeignClient(value = "cloud-product",path = "/api/product",fallback = ProductFeignFallback.class)
public interface IProductFeign {

    @GetMapping("/info")
    ResultResponse<String> info();

    @PostMapping("/reduction")
    Boolean reduction(@RequestBody ProductReductionRequest request);

}
