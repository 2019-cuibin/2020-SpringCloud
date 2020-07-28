package com.cb.cloud.controller;

import com.cb.cloud.service.FeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuibin
 * @date 2020-07-28 11:18
 */
@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "fallBackGlobal")
public class OrderHystrixController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/ok")
    public String payHystrix_ok(){
        return feignService.payHystrix_ok();
    }

    @RequestMapping("/error")
    @HystrixCommand(fallbackMethod = "fallBackTimeOut", commandProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            })
    public String payHystrix_error(){
        return feignService.payHystrix_error();
    }

    public String fallBackTimeOut(){
        return "服务超时，请稍后再试！";
    }

    /**
     * 使用全局降级处理
     * @return
     */
    @RequestMapping("/global")
    @HystrixCommand
    public String payHystrix_global(){
        return feignService.payHystrix_error();
    }

    /**
     * 作为一个全局的服务降级方法
     * @return
     */
    public String fallBackGlobal(){
        return "全局的服务降级的方法！";
    }
}
