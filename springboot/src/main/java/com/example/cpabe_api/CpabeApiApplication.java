package com.example.cpabe_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.cpabe_api.mapper")
public class  CpabeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpabeApiApplication.class, args);
    }

}
