package com.cb.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.cb.cloud.service.PayHystrixService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author cuibin
 * @date 2020-07-27 17:13
 */
@Service
public class PayHystrixServiceImpl implements PayHystrixService {
    @Override
    public String payHystrix_ok() {
        return "线程池：" + Thread.currentThread().getName() + "成功访问！" ;
    }

    @Override
    public String payHystrix_error(){
        //设置线程访问时间
        int time_out = 5000;
        try {
            TimeUnit.MILLISECONDS.sleep(time_out);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "访问超时，超时时间：" + time_out;
    }

    /**
     * 服务熔断
     * @return
     */
    @Override
    public String payHystrixCircuitBreaker(@PathVariable("id")Integer id) {
        if (id < 0){
            throw new RuntimeException("***********id 不能为负数*****");
        }
        String number = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + number;
    }
}
