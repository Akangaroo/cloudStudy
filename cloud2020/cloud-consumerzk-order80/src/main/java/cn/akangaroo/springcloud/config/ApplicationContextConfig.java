package cn.akangaroo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author kangyouwei
 * @version 1.0.0
 * @date 2020/12/13 10:38
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
