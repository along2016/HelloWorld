package com.example.demo.controller;

import com.example.demo.client.IHelloClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@RestController
public class HelloWorldController {

    @Resource
    private IHelloClient helloClient;

    @GetMapping("/hello")
    public String hello(){
        return helloClient.say();
    }

    @PostMapping("/hel")
    public String hel(){
        return "hello";
    }

    @RequestMapping("/helloWebFlux")
    public Mono<String> helloWorld(){
        return Mono.just("This is WebFlux demo");
    }
}
