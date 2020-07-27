package com.cb.cloud.consumer.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cuibin
 * @date 2020-07-27 11:29
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            System.out.println("*************current：" + current);
            next = current >= 2147483647 ? 0 : current + 1; //此处的2147483647表示的是Integer的最大值
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*********这表示的是第几次访问next："+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
