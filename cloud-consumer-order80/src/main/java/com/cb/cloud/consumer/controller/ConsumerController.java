package com.cb.cloud.consumer.controller;

import com.cb.cloud.common.entity.CommonResult;
import com.cb.cloud.common.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者
 * @author cuibin
 * @date 2020-07-08 15:52
 */
@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    private static final String PAY_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/selectAll")
    @ResponseBody
    public CommonResult<Order> selectAll(Order order){
        return restTemplate.postForObject(PAY_URL+"/order/selectAll",order,CommonResult.class);
    }
}
