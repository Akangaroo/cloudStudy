package cn.akangaroo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/30 14:07
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9902 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9902.class, args);
    }
}
