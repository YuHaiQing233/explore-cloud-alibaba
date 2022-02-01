package com.explore.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 产品 实体类
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 21:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * 主键Id
     */
    private Long id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品库存
     */
    private Integer inventory;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
