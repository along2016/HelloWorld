package com.example.demo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "topic";
        System.out.println("Sender:" + context);
        amqpTemplate.convertAndSend("topicExchange", "topic.1", context);
    }

    public void send2(){
        String context = "topic 2";
        System.out.println("Sender:" + context);
        amqpTemplate.convertAndSend("topicExchange", "topic.a", context);
    }

    public void send3(){
        String context = "topic 3";
        System.out.println("Sender:" + context);
        amqpTemplate.convertAndSend("topicExchange", "topic.b", context);
    }
}
