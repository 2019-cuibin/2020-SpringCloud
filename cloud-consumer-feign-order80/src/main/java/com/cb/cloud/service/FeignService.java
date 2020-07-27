package com.cb.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author cuibin
 * @date 2020-07-27 15:22
 */
@Component
@FeignClient() //接口+此注解
public interface FeignService {
}
