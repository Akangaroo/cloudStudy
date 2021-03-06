package cn.akangaroo.springcloud.controller;

import cn.akangaroo.springcloud.entities.CommonResult;
import cn.akangaroo.springcloud.entities.Payment;
import cn.akangaroo.springcloud.lb.ILoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/7 17:34
 **/
@RestController
@Slf4j
public class OrderController {

    @Value("${my-url}")
    private String PAYMENT_URL;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ILoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        // 两个参数，请求的地址，返回的类型
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        log.info("****查询的id：" + id);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id,
                                                    CommonResult.class);
        // 获得状态码
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/createEntity")
    public CommonResult<Payment> create2(Payment payment){
        log.info("********插入的数据：" + payment);
        //postForObject分别有三个参数：请求地址，请求参数，返回的对象类型
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        // 获得CLOUD-PAYMENT-SERVICE的实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null && instances.size() <= 0) {
            return null;
        }
        // 调用手写的轮询负载均衡算法
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        // 通过手写的轮询的算法获得调用的某个uri
        URI uri = serviceInstance.getUri();
        System.out.println(uri);
        // 通过restTemplate调用
        return restTemplate.getForObject(uri + "payment/lb", String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin", String.class);
        return result;
    }

}
