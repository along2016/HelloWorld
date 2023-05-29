package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CustomSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String queueName, String msg){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送时间：" + sdf.format(new Date()));
        rabbitTemplate.convertAndSend("delayed_exchange", queueName, msg, message -> {
            // 消息延迟5s
            message.getMessageProperties().setHeader("x-delay", 5000);
            return message;
        });
    }
}
