package com.cb.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author cuibin
 * @date 2020-07-31 15:29
 */
@RestController
@RequestMapping("/nacos")
public class NacosOrderController {

    @Autowired
    private RestTemplate restTemplate;

    private String uri = "http://cloudAlibaba-nacos-server/nacos/putId/";

    /**
     * 根据服务名称进行服务调用
     * @param id
     * @return
     */
    @RequestMapping("/putId/{id}")
    public String putId(@PathVariable("id") Integer id){
        String result = restTemplate.getForObject(uri + id, String.class);
        return result;
    }
}
