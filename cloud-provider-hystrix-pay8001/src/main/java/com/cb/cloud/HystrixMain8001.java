package com.cb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * @author cuibin
 * @date 2020-07-27 16:02
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixMain8001.class,args);
    }
}
