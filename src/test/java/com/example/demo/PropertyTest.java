package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PropertyTest {
    @Value("${age}")
    private int age;

    @Value("${name}")
    private String name;

    @Value("${myenvironment.name}")
    private String environment;

    @Autowired
    private GetPersonInfoProperties getPersonInfoProperties;

    @Test
    public void getAge(){
        System.out.println(age);
    }

    @Test
    public void getName() {
        System.out.println(name);
    }

    @Test
    public void getPersonInfoProperties(){
        System.out.println(getPersonInfoProperties.getName() + ":" + getPersonInfoProperties.getAge());
    }

    @Test
    public void getEnvironmentName(){
        System.out.println(environment);
    }
}
