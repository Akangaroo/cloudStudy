package cn.akangaroo.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/30 14:51
 **/
@RestController
public class OrderNacosController {

    @Value("${service-url.nacos-user-service}")
    public String ServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        String result = restTemplate.getForObject(ServiceUrl + "/payment/nacos/" + id, String.class);
        return result;
    }
}
