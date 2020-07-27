package com.cb.cloud.consumer.controller;

import com.cb.cloud.common.entity.CommonResult;
import com.cb.cloud.common.entity.Order;
import com.cb.cloud.consumer.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;


/**
 * 消费者
 * @author cuibin
 * @date 2020-07-08 15:52
 */
@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    private static final String PAY_URL = "http://cloud-pay-service";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/selectAll")
    @ResponseBody
    public CommonResult<Order> selectAll(Order order){
        return restTemplate.postForObject(PAY_URL+"/order/selectAll",order,CommonResult.class);
    }

    /**
     * 使用自己写的负载均衡的方法
     * @return
     */
    @RequestMapping("/getPort")
    @ResponseBody
    public String getPort(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAY-SERVICE");
        if (serviceInstances == null || serviceInstances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instance(serviceInstances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/order/getPort",String.class);
    }
}
