package com.thoughtworks.school;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
class EmployeeAlreadyExistedException extends RuntimeException {

    public EmployeeAlreadyExistedException(int employeeId) {
        super("employee with id '" + employeeId + "' already exists.");
    }
}
