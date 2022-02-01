package com.explore.product.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 产品 减库存 请求Bean
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 21:53
 */
@Data
@ToString
public class ProductReductionRequest implements Serializable {

    /**
     * 产品Id
     */
    private Long productId;

    /**
     * 数量
     */
    private Integer quantity;

}
