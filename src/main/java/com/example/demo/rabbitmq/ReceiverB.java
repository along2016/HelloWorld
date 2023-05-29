package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
// 监听 QueueHello 的消息队列
@RabbitListener(queues = "topic.b")
public class ReceiverB {

    // @RabbitHandler 来实现具体消费
    @RabbitHandler
    public void queueReceiver(String queue){
        System.out.println("Receiver B:" + queue);
    }
}
