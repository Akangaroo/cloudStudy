package cn.akangaroo.springcloud.service;

import cn.akangaroo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/7 15:16
 **/
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
