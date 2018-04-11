package com.thoughtworks.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@SpringBootApplication
public class application {

    @RequestMapping("/")
    String home(){
        return "my home";
    }

    @RequestMapping("/employees")
    @ResponseBody
    List<Employee> getEmployees(){
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(0, "小明", 20, "男"));
        employees.add(new Employee(1, "小红", 19, "女"));
        employees.add(new Employee(2, "小智", 25, "男"));
        employees.add(new Employee(3, "小刚", 16, "男"));
        employees.add(new Employee(4, "小霞", 15, "女"));
        return employees;
    }

    public static void main(String[] args){
        SpringApplication.run(application.class, args);
    }
}
