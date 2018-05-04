package com.thoughtworks.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class application {
    public application() {
    }

    @RequestMapping("/")
    String home(){
        return "my home";
    }

    public static void main(String[] args){
        SpringApplication.run(application.class, args);
    }
}
