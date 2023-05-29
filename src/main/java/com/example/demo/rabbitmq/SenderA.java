package com.example.demo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderA {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String context){
        System.out.println("Sender:" + context);
        // 使用 AmqpTemplate 将消息发送到消息队列中
        rabbitTemplate.convertAndSend("Queue1", context);
    }
}
