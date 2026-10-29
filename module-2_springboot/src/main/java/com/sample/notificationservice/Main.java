package com.sample.notificationservice;

public class Main {
    static void main(String[] args) {
        AnnotationConfig
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
      student student = ctx.getBean(Student.class);
      student.notifyStudent();
    }
}
