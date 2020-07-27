package com.cb.cloud.service;

import org.springframework.stereotype.Service;

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
            TimeUnit.SECONDS.sleep(time_out);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "访问超时，超时时间：" + time_out;
    }
}
