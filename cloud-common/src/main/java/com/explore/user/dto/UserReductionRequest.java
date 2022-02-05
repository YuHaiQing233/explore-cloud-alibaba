package com.explore.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户扣款请求Bean
 *
 * @author: YuHaiQing
 * @time: 2022/2/4 10:21
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserReductionRequest implements Serializable {

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 扣款金额
     */
    private BigDecimal money;

}
