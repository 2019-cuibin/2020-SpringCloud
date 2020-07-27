package com.cb.cloud.consumer.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author cuibin
 * @date 2020-07-27 11:27
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
