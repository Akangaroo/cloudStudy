package cn.edu.springcloud.lb.Impl;

import cn.edu.springcloud.lb.ILoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kangyouwei
 * @version 1.0.0
 * @date 2020/12/20 0:23
 */
@Component
public class LoadBalancerImpl implements ILoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("****第几次访问：" + next);

        return  next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        if (serviceInstances.size() <= 0) {
            return null;
        }
        // 进行取余
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
