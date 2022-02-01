package com.explore.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 产品 Mapper接口 类
 *
 * @author: HaiQing.Yu
 * @time: 2022/2/1 21:41
 */
@Mapper
public interface ProductMapper {

    /**
     * 减库存
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 21:44
     */
    Integer reduction(@Param("productId") Long productId, @Param("quantity") Integer quantity);

}
