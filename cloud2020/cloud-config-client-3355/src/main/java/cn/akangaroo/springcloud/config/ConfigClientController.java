package cn.akangaroo.springcloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangyouwei
 * @version 1.0.0
 * @date 2020/12/20 16:33
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")	//spring的@Value注解
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
