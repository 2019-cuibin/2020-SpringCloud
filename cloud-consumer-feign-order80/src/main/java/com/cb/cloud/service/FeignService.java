package com.cb.cloud.service;

import com.cb.cloud.service.impl.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cuibin
 * @date 2020-07-27 15:22
 */
@Component
@FeignClient(name = "CLOUD-PAY-HYSTRIX-SERVICE", fallback = FeignServiceImpl.class) //接口+此注解==>name是注册的微服务名称
public interface FeignService {

    @RequestMapping("/pay/ok") //此处需要注意访问路径是否完整
    public String payHystrix_ok();

    @RequestMapping("/pay/error")
    public String payHystrix_error();
}
