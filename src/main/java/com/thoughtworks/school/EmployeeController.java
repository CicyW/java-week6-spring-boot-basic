package com.thoughtworks.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;


    @GetMapping
    List<Employee> getEmployees(){
        return employeeService.getEmployeeList();
    }

    @GetMapping("{employeeId}")
    Employee getEmployee(@PathVariable int employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Employee createEmployee(@RequestBody Employee input) throws Exception {
       return employeeService.saveEmployee(input);
    }

    @PutMapping("{employeeId}")
    Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee input) throws Exception {
        return employeeService.updateEmployee(employeeId, input);
    }

    @DeleteMapping("{employeeId}")
    void deleteEmployee(@PathVariable int employeeId) throws Exception {
        employeeService.deleteEmployee(employeeId);
    }
}
