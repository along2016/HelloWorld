package com.example.demo;

import com.example.demo.rabbitmq.CustomSender;
import com.example.demo.rabbitmq.FanoutSender;
import com.example.demo.rabbitmq.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TopicTests {

	@Autowired
	private TopicSender topicSender;
	@Autowired
	private FanoutSender fanoutSender;
	@Autowired
	private CustomSender customSender;

	@Test
	public void topic(){
		topicSender.send();
	}

	@Test
	public void topic1(){
		topicSender.send2();
	}

	@Test
	public void topic2(){
		topicSender.send3();
	}

	@Test
	public void fanoutSenderTest(){
		fanoutSender.send();
	}

	@Test
	public void send(){
		customSender.sendMsg("delay_queue_1", "支付超时，取消订单通知！");
	}
}
