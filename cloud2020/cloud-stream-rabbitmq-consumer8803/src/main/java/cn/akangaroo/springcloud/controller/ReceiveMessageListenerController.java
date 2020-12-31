package cn.akangaroo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author kangyouwei
 * @version v1.0.0
 * @date 2020/12/29 17:54
 **/
@Component
@EnableBinding({Sink.class})
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者2号------>收到的消息：" + message.getPayload() + "\t port：" + serverPort);
    }
}
