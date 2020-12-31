package cn.akangaroo.springcloud.service;

import cn.akangaroo.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author kangyouwei
 * @version 1.0.0
 * @date 2020/12/20 12:26
 */
//Feign封装了Ribbon和RestTemplate，实现负载均衡和发送请求
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")    //作为feign的接口，找CLOUD-PAYMENT-SERVICE服务
public interface PaymentFeignService {

    //直接复制8001的方法
    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
