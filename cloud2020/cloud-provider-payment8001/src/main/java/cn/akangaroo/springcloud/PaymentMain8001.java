package cn.akangaroo.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/7 14:55
 **/
@MapperScan("cn.edu.cn.edu.springcloud.dao")
@SpringBootApplication
@EnableEurekaClient // 表示是Eureka的客户端
@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
