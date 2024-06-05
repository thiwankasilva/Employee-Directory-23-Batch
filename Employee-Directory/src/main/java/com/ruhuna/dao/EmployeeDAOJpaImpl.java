package com.ruhuna.dao;

import com.ruhuna.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;

//We used this annotation because this class provide mechanism to deal with the database operations
//Read Update Delete Search Add
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    //EntityManager dependency will be automatically injected when we used @Autowired Annotation
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery("from Employee",Employee.class);

        List<Employee> employeesList = employeeTypedQuery.getResultList();

        return employeesList;
    }

    @Override
    public Employee findById(String id) {
        Employee employee = entityManager.find(Employee.class,id);

        return employee;
    }

    //By using interfaces we are achieving abstraction
    @Override
    public void save(Employee employee) {

        //If we used JDBC - Java database connectivity
        //Insert Into table_name values("","")

        //JPA Way
        //By merging the entity it will merge if theres any previous record or it will create a new record if there isn't any
        Employee employeeSaved = entityManager.merge(employee);

    }

    @Override
    public void deleteById(String id) {
        //Find whether there's a employee with that id
        Employee employee = entityManager.find(Employee.class,id);

        entityManager.remove(employee);
    }
}
