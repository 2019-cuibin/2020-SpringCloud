package com.cb.cloud.controller;

import com.cb.cloud.service.PayHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
