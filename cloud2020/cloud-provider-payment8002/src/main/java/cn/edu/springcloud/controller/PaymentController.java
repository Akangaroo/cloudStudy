package cn.edu.springcloud.controller;

import cn.edu.springcloud.entities.CommonResult;
import cn.edu.springcloud.entities.Payment;
import cn.edu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/7 15:18
 **/
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入数据为：" + payment);
        log.info("****插入结果为：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功 端口号为：" + serverPort, result);
        } else {
            return new CommonResult(400, "插入数据失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果为：" + payment + "haha\n");

        if (payment != null) {
            return new CommonResult(200, "查询成功 端口号为：" + serverPort, payment);
        } else {
            return new CommonResult(400, "没有查询到，查询Id为：" + id);
        }
    }

    @GetMapping("/payment/discovery")
    public Object getDiscovery() {
        // 获取服务信息的列表
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****service:" + service);
        }

        // 获取CLOUD-PAYMENT-SERVICE服务的所有具体实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            // getServiceId服务器id getHost主机名称 getPort端口号  getUri地址
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" +
                    instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
