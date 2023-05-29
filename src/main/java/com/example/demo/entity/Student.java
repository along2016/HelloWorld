package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {

    private String name;

    private int age;

    private Teacher teacher;

    private Teacher teacher2;

    /**
     * 构造器或者叫构造函数注入
     */
//    @Autowired
//    public Student(Teacher teacher, Teacher teacher2) {
//        this.teacher = teacher;
//        this.teacher2 = teacher2;
//    }

    /**
     * Setter注入
     * @param teacher
     */
    @Autowired
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Autowired
    public void setTeacher2(Teacher teacher2) {
        this.teacher2 = teacher2;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeacherName(){
        return "老师的名字是：" + teacher.getName();
    }

    public String getTeacher2Name(){
        return "老师的名字是：" + teacher2.getName();
    }
}
