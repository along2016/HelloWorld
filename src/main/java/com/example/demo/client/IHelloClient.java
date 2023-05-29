package com.example.demo.client;

import com.example.demo.client.fallback.HelloClientFallBack;
import com.my.spring.cloud.client.HelloClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "product-center", fallback = HelloClientFallBack.class)
public interface IHelloClient extends HelloClient {
}
