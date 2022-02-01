package com.explore.product.service;

import com.explore.product.dto.ProductReductionRequest;

/**
 * 产品服务 业务逻辑接口类
 *
 * @author: HaiQing.Yu
 * @time: 2022/2/1 21:49
 */
public interface IProductService {

    /**
     * 减库存
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 21:50
     */
    Boolean reduction(ProductReductionRequest request);

}
