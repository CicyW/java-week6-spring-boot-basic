package com.thoughtworks.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.GET)
    ResponseEntity<?> getEmployee(@PathVariable int employeeId){
        boolean match = employees.stream().anyMatch(e -> e.getId() == employeeId);
        if(!match)
            return new ResponseEntity<>("cannot find such employee with input id", HttpStatus.NOT_FOUND);
        Employee employee = employees.stream().filter(e -> e.getId() == employeeId).findFirst().get();
        return new ResponseEntity<Object>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    ResponseEntity<?> createEmployee(@RequestBody Employee input){
        boolean match = employees.stream().anyMatch(e -> e.getId() == input.getId());
        if(match)
            return new ResponseEntity<>("The employee id already exist", HttpStatus.CONFLICT);
        employees.add(input);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.PUT)
    ResponseEntity<?> updateEmployee(@PathVariable int employeeId, @RequestBody Employee input){
        boolean match = employees.stream().anyMatch(e -> e.getId() == employeeId);
        if(!match)
            return new ResponseEntity<>("cannot find such employee with input id", HttpStatus.NOT_FOUND);
        Employee employee = employees.stream().filter(e -> e.getId() == employeeId).findFirst().get();
        employee.setAge(input.getAge());
        employee.setGender(input.getGender());
        employee.setName(input.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{employeeId}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteEmployee(@PathVariable int employeeId){
        boolean match = employees.stream().anyMatch(e -> e.getId() == employeeId);
        if(!match)
            return new ResponseEntity<>("cannot find such employee with input id", HttpStatus.NOT_FOUND);
        Employee employee = employees.stream().filter(e -> e.getId() == employeeId).findFirst().get();
        employees.remove(employee);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    public static void main(String[] args){
        SpringApplication.run(application.class, args);
    }
}
