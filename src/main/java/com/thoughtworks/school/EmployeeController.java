package com.thoughtworks.school;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    List<Employee> employees;

    public EmployeeController() {
        employees = new ArrayList<>();
        employees.add(new Employee(0, "小明", 20, "男"));
        employees.add(new Employee(1, "小红", 19, "女"));
        employees.add(new Employee(2, "小智", 25, "男"));
        employees.add(new Employee(3, "小刚", 16, "男"));
        employees.add(new Employee(4, "小霞", 15, "女"));
    }

    @GetMapping
    List<Employee> getEmployees(){
        return employees;
    }

    @GetMapping("{employeeId}")
    Employee getEmployee(@PathVariable int employeeId){
        this.validateEmployee(employeeId);
        Employee employee = employees.stream().filter(e -> e.getId() == employeeId).findFirst().get();
        return employee;
    }

    private void validateEmployee(int employeeId) {
        boolean match = employees.stream().anyMatch(e -> e.getId() == employeeId);
        if (!match)
            throw new EmployeeNotFoundException(employeeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Employee createEmployee(@RequestBody Employee input){
        boolean match = employees.stream().anyMatch(e -> e.getId() == input.getId());
        if(match)
            throw new EmployeeAlreadyExistedException(input.getId());
        employees.add(input);
        return input;
    }

    @PutMapping("{employeeId}")
    Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee input){
        this.validateEmployee(employeeId);
        Employee employee = employees.stream().filter(e -> e.getId() == employeeId).findFirst().get();
        employee.setAge(input.getAge());
        employee.setGender(input.getGender());
        employee.setName(input.getName());
        return employee;
    }

    @DeleteMapping("{employeeId}")
    void deleteEmployee(@PathVariable int employeeId){
        this.validateEmployee(employeeId);
        Employee employee = employees.stream().filter(e -> e.getId() == employeeId).findFirst().get();
        employees.remove(employee);
    }
}
