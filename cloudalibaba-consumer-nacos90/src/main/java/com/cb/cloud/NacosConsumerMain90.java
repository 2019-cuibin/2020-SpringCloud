package com.cb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author cuibin
 * @date 2020-07-31 15:23
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class NacosConsumerMain90 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerMain90.class,args);
    }
}
