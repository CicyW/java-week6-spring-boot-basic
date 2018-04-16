package com.thoughtworks.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@SpringBootApplication
public class application {
    List<Employee> employees = new ArrayList<Employee>();

    public application() {
        employees.add(new Employee(0, "小明", 20, "男"));
        employees.add(new Employee(1, "小红", 19, "女"));
        employees.add(new Employee(2, "小智", 25, "男"));
        employees.add(new Employee(3, "小刚", 16, "男"));
        employees.add(new Employee(4, "小霞", 15, "女"));
    }

    @RequestMapping("/")
    String home(){
        return "my home";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    List<Employee> getEmployees(){
        return employees;
    }

    @RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
    Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employees.stream().filter(e -> e.getId() == employeeId).findFirst().get();
        return employee;
    }


    public static void main(String[] args){
        SpringApplication.run(application.class, args);
    }
}
