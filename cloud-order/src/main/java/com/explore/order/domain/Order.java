package com.explore.order.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单 实体Bean
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 22:02
 */
@Data
@ToString
public class Order implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户服务
     */
    private Long userId;

    /**
     * 产品Id
     */
    private Long productId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 产品单价
     */
    private BigDecimal price;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
