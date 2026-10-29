package com.student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        return new Course("C01", "Java Full Stack", 4);
    }

    @Bean
    public Student student(Course course) {
        return new Student(101, "Aditi Sharma", course);
    }

    @Bean
    public StudentService studentService(Student student) {
        return new StudentService(student);
    }
}
