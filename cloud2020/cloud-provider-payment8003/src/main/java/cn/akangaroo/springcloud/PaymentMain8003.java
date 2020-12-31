package cn.akangaroo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kangyouwei
 * @version 1.0.0
 * @date 2020/12/13 9:54
 */
@SpringBootApplication
@EnableDiscoveryClient    //该注解用于向使用consul或者Zookeeper作为注册中心时注册服务
public class PaymentMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8003.class, args);
    }
}
