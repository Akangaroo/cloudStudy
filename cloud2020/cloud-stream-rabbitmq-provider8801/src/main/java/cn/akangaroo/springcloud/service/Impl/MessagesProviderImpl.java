package cn.akangaroo.springcloud.service.Impl;

import cn.akangaroo.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/29 17:25
 **/
@EnableBinding(Source.class) // 定义消息的推送管道
public class MessagesProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("****serial:" + serial);
        return null;
    }
}
