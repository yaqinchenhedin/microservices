package com.in28minutes.springboot.microservice.example.forex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootMicroserviceForexServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroserviceForexServiceApplication.class, args);
    }
}