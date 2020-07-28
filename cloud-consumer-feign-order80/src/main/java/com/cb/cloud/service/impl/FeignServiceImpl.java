package com.cb.cloud.service.impl;

import com.cb.cloud.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * 作为一个全局的类，对所有的方法进行降级处理
 * @author cuibin
 * @date 2020-07-28 14:43
 */
@Component
public class FeignServiceImpl implements FeignService {
    @Override
    public String payHystrix_ok() {
        return "使用实现类====》ok降级成功";
    }

    @Override
    public String payHystrix_error() {
        return "使用实现类===》error降级成功";
    }
}
