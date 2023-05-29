package com.example.demo.client.fallback;

import com.example.demo.client.IHelloClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * openFeign接口调用失败后，通过hystrix降级
 */
@Component
public class HelloClientFallBack implements IHelloClient {

    @Override
    @RequestMapping("/say/fail")
    public String say() {
        System.out.println("降级了");
        return "call failed";
    }
}
