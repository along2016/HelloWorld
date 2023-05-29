package com.example.demo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "Fanout";
        System.out.println("Sender:" + context);
        amqpTemplate.convertAndSend("fanoutExchange", "", context);
    }
}
