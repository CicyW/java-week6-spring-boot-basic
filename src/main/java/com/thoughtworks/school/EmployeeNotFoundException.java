package com.thoughtworks.school;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(int employeeId) {
        super("could not find employee '" + employeeId + "'.");
    }
}
