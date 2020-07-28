package com.cb.cloud.controller;

import com.cb.cloud.service.PayHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuibin
 * @date 2020-07-27 17:20
 */
@RestController
@RequestMapping("/pay")
public class PayHystrixController {

    @Autowired
    private PayHystrixService payHystrixService;

    /**
     * 成功
     * @return
     */
    @RequestMapping("/ok")
    public String payHystrix_ok(){
        return payHystrixService.payHystrix_ok();
    }

    /**
     * 错误
     * @return
     */
    @RequestMapping("/error")
   public String payHystrix_error(){
       return payHystrixService.payHystrix_error();
   }


   //==================服务熔断================
   @RequestMapping("/circuitBreaker/{id}")
   @HystrixCommand(fallbackMethod = "payFallBack", commandProperties = {
           @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //表示开启熔断
           @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //一个周期内的请求次数
           @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //周期的时间==》此处是10秒
           @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //在一个请求周期中错误请求的比例
   })
    public String payHystrixCircuitBreaker(@PathVariable("id") Integer id){
        String result = payHystrixService.payHystrixCircuitBreaker(id);
        return result;
    }

    public String payFallBack(@PathVariable("id")Integer id){
        return "id 不能为负数。请稍后再试！id======>" + id;
    }
}
