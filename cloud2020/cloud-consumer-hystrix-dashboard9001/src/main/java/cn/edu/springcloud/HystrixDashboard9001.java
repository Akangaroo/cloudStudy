package cn.edu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author kangyouwei
 * @version 1.0.0
 * @date 2020/12/20 15:07
 */
@SpringBootApplication
@EnableHystrixDashboard //启用Hystrix仪表板
public class HystrixDashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001.class, args);
    }
}
