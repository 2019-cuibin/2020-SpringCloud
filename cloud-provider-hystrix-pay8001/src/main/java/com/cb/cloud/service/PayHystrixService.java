package com.cb.cloud.service;

import org.springframework.stereotype.Service;

/**
 * @author cuibin
 * @date 2020-07-27 17:08
 */
public interface PayHystrixService {
    /**
     * 成功
     * @return
     */
    String payHystrix_ok();

    /**
     * 错误
     * @return
     */
    String payHystrix_error();
}
