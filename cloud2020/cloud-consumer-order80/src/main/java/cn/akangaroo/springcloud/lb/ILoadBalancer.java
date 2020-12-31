package cn.akangaroo.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author kangyouwei
 * @version 1.0.0
 * @date 2020/12/20 0:21
 */
public interface ILoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
