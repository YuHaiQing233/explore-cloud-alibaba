package com.explore.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 响应报文 模板
 *
 * @author: YuHaiQing
 * @time: 2022/2/4 10:09
 */
@Slf4j
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse <T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    public ResultResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 异常响应结果
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/4 10:12
     */
    public static ResultResponse error(int code, String msg){
        return new ResultResponse(code,msg);
    }

    /**
     * 成功响应结果
     *
     * @author: HaiQing.Yu
     * @time: 2022/2/4 10:13
     */
    public static <T> ResultResponse success(T data){
        return new ResultResponse(200,"成功",data);
    }

}
