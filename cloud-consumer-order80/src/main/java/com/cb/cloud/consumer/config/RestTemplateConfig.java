package com.cb.cloud.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * restTemplate是用于应用服务之间的相互调用，对HttpClient的进一步封装，简化操作
 * @author cuibin
 * @date 2020-07-08 15:55
 */
@Configuration
public class RestTemplateConfig {

    @Bean
   // @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
