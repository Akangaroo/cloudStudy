package cn.akangaroo.springcloud.Service.Impl;

import cn.akangaroo.springcloud.Service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author kangyouwei
 * @version 1.0.0
 * @date 2020/12/20 14:31
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService\t fallback-paymentInfo_OK----";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService\t fallback-paymentInfo_TimeOut----";
    }
}
