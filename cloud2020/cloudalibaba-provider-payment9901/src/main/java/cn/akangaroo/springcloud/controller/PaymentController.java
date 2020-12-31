package cn.akangaroo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/30 14:07
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "nacos registry, serverPort: " + serverPort + "\t id: " + id;
    }

}
