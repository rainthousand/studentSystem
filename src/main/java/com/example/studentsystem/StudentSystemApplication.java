package com.example.studentsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.studentsystem.mapper")
public class StudentSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentSystemApplication.class, args);
    }

}
