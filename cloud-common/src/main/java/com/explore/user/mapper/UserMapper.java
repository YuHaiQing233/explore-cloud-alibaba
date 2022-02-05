package com.explore.user.mapper;

import com.explore.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * 用户映射器
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 19:14
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户Id查询用户信息
     *
     * @param userId 用户Id
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 19:15
     */
    User getById(@Param("userId") Long userId);

    /**
     * 扣余额
     *
     * @param userId 用户Id
     * @param money 扣款金额
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/1 19:16
     */
    Integer reduction(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
