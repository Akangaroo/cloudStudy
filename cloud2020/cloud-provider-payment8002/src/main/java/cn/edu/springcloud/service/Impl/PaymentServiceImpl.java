package cn.edu.springcloud.service.Impl;

import cn.edu.springcloud.dao.PaymentDao;
import cn.edu.springcloud.entities.Payment;
import cn.edu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/7 15:17
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        int result = paymentDao.create(payment);
        return result;
    }

    @Override
    public Payment getPaymentById(Long id) {
        Payment paymentById = paymentDao.getPaymentById(id);
        return paymentById;
    }
}
