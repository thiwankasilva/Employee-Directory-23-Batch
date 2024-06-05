package com.ruhuna.dao;

import com.ruhuna.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(String id);
}
