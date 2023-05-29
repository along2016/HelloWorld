package com.example.demo.config;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.task.TaskExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class BeanConfig {

    @Bean
    public ThreadPoolExecutor executorService(){
        return new ThreadPoolExecutor(
                16,
                32,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(128));
    }

    /**
     * 使用 @Bean 注解表明 student_1 需要交给 Spring 容器管理，
     * 未指定 bean 的名称，默认采用的是 "方法名" + "首字母小写"的配置方式；
     * 如果用 @Bean 标注了多个同一类型的bean（比如 Student），则需要为每一个方法指定
     * 不通的方法名，在其他类中引用这些对象时需要将字段名称与该方法名称一致。
     * @return
     */
    @Bean
    public Student student_1(){
        Student student = new Student();
        student.setAge(30);
        return student;
    }

    /**
     * 为 student_2 起三个名字，s1、s2、s3
     * @Scope 默认为 singleton，但是可以指定其作用域
     * prototype 是多例的，即每一次调用都会生成一个新的实例。
     */
    @Bean({"s1" , "s2", "s3"})
    @Scope("prototype")
    public Student student_2(){
        Student student = new Student();
        student.setAge(32);
        return student;
    }

    @Bean
    public Student grateStudent(@Qualifier("student_1") Student student_3, Student s2){
        Student student = new Student();
        student.setAge(student_3.getAge() + s2.getAge());
        return student;
    }

    @Bean
    public Teacher teacher(){
        Teacher teacher = new Teacher();
        teacher.setName("王吉亮");
        return teacher;
    }

    @Bean("teacher2")
    public Teacher teacher3(){
        Teacher teacher = new Teacher();
        teacher.setName("倪琳");
        return teacher;
    }
}
