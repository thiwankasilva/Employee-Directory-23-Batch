package com.ruhuna.service;

import com.ruhuna.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();
    Employee findEmployeeById(String id);
}
