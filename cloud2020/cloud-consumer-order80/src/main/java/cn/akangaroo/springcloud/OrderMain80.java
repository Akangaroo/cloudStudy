package cn.akangaroo.springcloud;

import cn.akangaroo.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/7 17:32
 **/
@SpringBootApplication
@EnableEurekaClient
// @RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
// @RibbonClient(name = "CLOUD-GATEWAY", configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
