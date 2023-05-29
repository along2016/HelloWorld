package com.example.demo.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue queue(){
        return new Queue("topic.a");
    }

    @Bean
    public Queue objectQueue(){
        return new Queue("topic.b");
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("topic.a");
    }

    @Bean
    Binding bindingObjectQueue(Queue objectQueue, TopicExchange exchange){
        return BindingBuilder.bind(objectQueue).to(exchange).with("topic.#");
    }

    @Bean
    public Queue queueA(){
        return new Queue("fanout.A");
    }

    @Bean
    public Queue queueB(){
        return new Queue("fanout.B");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding fanoutExchangeA(Queue queueA, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    @Bean
    Binding fanoutExchangeB(Queue queueB, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }

//    @Bean
//    public CustomExchange delayExchange(){
//        Map<String, Object> args = new HashMap<>();
//        args.put("x-delayed-type", "direct");
//        return new CustomExchange("delayed_exchange", "x-delayed-message", true, false, args);
//    }

    @Bean
    public Queue delayQueue(){
        return new Queue("delay_queue_1");
    }

//    @Bean
//    Binding bindDelayExchange(Queue delayQueue, CustomExchange delayExchange){
//        return BindingBuilder.bind(delayQueue).to(delayExchange).with("delay_queue_1").noargs();
//    }
}
