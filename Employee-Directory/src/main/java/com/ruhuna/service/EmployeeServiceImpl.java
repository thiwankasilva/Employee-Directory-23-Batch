package com.ruhuna.service;

import com.ruhuna.dao.EmployeeDAOJpaImpl;
import com.ruhuna.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAOJpaImpl employeeDAOJpa;

    //constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAOJpaImpl employeeDAOJpa) {
        this.employeeDAOJpa = employeeDAOJpa;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAOJpa.findAll();
    }

    @Override
    public Employee findEmployeeById(String id) {
        return employeeDAOJpa.findById(id);
    }
}
