package com.ruhuna.service;

import com.ruhuna.dao.EmployeeDAOJpaImpl;
import com.ruhuna.model.Employee;
import jakarta.transaction.Transactional;
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

    //we need to add @Transactional annotation when we are updating the DB
    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAOJpa.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        employeeDAOJpa.deleteById(id);
    }
}
