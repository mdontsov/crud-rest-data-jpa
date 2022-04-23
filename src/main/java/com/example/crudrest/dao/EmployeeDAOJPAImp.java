package com.example.crudrest.dao;

import com.example.crudrest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImp implements EmployeeDAO {

    private final EntityManager manager;

    @Autowired // Constructor injection. @Autowired is optional IF one Constructor per class
    public EmployeeDAOJPAImp(EntityManager manager) {
        this.manager = manager;
    }

    // EntityManager methods: JPA API (V2)
    @Override
    public List<Employee> findAll() {
        Query query = manager.createQuery("from Employee order by id asc");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        manager.persist(employee); // ID == 0 ? Save : Update
        return employee;
    }

    @Override
    public Employee readEmployee(int id) {
        Employee employee = manager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        manager.merge(employee);
        return employee;
    }

    @Override
    public String deleteEmployee(int id) {
        Employee employee = manager.find(Employee.class, id);
        manager.remove(employee);
        return "Deleted employee with id: ".concat(String.valueOf(employee.getId()));
    }
}
