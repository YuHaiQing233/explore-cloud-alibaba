package com.explore.product.service.impl;

import com.explore.product.dto.ProductReductionRequest;
import com.explore.product.mapper.ProductMapper;
import com.explore.product.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: YuHaiQing
 * @time: 2022/2/1 21:50
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Boolean reduction(ProductReductionRequest request) {

        final Integer reduction = productMapper.reduction(request.getProductId(), request.getQuantity());
        if(null != reduction && reduction > 0){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
