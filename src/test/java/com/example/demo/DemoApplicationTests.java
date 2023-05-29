package com.example.demo;

import com.example.demo.rabbitmq.ObjectSender;
import com.example.demo.rabbitmq.SenderA;
import com.example.demo.redis.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.ribbon.RibbonApplicationContextInitializer;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

	@Qualifier("stringRedisTemplate")
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private SenderA queueSender;
	@Autowired
	private ObjectSender objectSender;

	@Test
	void contextLoads() {
		redisTemplate.opsForValue().set("num", "123");
		System.out.println("=======" + redisTemplate.opsForValue().get("num"));
	}

	@Test
	public void queueSend(){
		int i = 10;
		for (int j = 0; j < i; j++) {
			String msg = "Queue1 msg" + j + new Date();
			queueSender.send(msg);
		}
	}

	@Test
	public void sendObject(){
		User user = new User();
		user.setName("wangjiliang");
		user.setAge(32);
		objectSender.send(user);
	}

	public static void main(String[] args) {
		String pass = "123456";
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		String hashPass = bcryptPasswordEncoder.encode(pass);
		System.out.println(hashPass);

		boolean f = bcryptPasswordEncoder.matches("admin",hashPass);
		System.out.println(f);
	}
}
