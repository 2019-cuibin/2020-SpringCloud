package com.cb.cloud.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 公共的结果返回类
 * @author cuibin
 * @date 2020-07-08 10:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    /** 返回码 **/
    private Integer code;

    /** 返回信息 **/
    private String message;

    /** 返回数据 **/
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }
}
