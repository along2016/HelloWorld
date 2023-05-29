package com.example.demo;

import com.example.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BeanTest {

    @Autowired
    private Student s3;

    @Test
    public void testBean(){
        System.out.println("======1=======" + s3.getTeacherName());
        System.out.println("======2=======" + s3.getTeacher2Name());
        System.out.println("======2=======" + s3.getAge());
    }
}
