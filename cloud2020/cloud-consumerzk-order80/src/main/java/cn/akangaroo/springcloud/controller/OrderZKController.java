package cn.akangaroo.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author kangyouwei
 * @version 1.0.0
 * @date 2020/12/13 10:40
 */
@RestController
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/zk")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }
}
