package com.cb.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author cuibin
 * @date 2020-07-27 15:19
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker //开启熔断降级的开关
public class OpenFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMain80.class,args);
    }
}
