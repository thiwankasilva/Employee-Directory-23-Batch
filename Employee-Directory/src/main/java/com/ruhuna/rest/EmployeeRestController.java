package com.ruhuna.rest;

import com.ruhuna.dao.EmployeeDAO;
import com.ruhuna.model.Employee;
import com.ruhuna.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> employeeList = employeeService.findAllEmployees();

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id)
    {
        Employee employee = employeeService.findEmployeeById(id);

        if(employee == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<String> addNewEmployee(@RequestBody Employee employee)
    {
        employeeService.saveEmployee(employee);

        return new ResponseEntity<>("Employee Saved Successfully", HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee)
    {
        employeeService.saveEmployee(employee);

        return new ResponseEntity<>("Employee updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteEmpoyeeById(@PathVariable String employeeId)
    {
        Employee tempEmployee = employeeService.findEmployeeById(employeeId);

        if(tempEmployee  == null)
        {
            return new ResponseEntity<>("There's no any employee with that Id",HttpStatus.NOT_FOUND);
        }

        employeeService.deleteById(employeeId);
        return new ResponseEntity<>("Employee Deleted Successfully", HttpStatus.OK);
    }



}
