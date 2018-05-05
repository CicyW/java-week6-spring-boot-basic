package com.thoughtworks.school;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployeeList();
    Employee saveEmployee(Employee employee) throws Exception;
    Employee getEmployee(int id);
    Employee updateEmployee(int id, Employee employee) throws Exception ;
    void deleteEmployee(int id) throws Exception ;
}
