package com.example.crudrest.dao;

import com.example.crudrest.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {

    private final EntityManager manager; // <- Created automatically by Spring Boot

    @Autowired // Constructor injection. @Autowired is optional IF one Constructor per class
    public EmployeeDAOHibernateImp(EntityManager manager) {
        this.manager = manager;
    }

    // Session methods: Native Hibernate API (V1)
    @Override
    public List<Employee> findAll() {
        Session session = manager.unwrap(Session.class); // <- Get current Hibernate session
        Query query = session.createQuery("from Employee order by id asc");
        return (List<Employee>) query.getResultList();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Session session = manager.unwrap(Session.class);
        session.saveOrUpdate(employee); // ID == 0 ? Save : Update
        return employee;
    }

    @Override
    public Employee readEmployee(int id) {
        Session session = manager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Session session = manager.unwrap(Session.class);
        session.update(employee);
        return employee;
    }

    @Override
    public String deleteEmployee(int id) {
        Session session = manager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        session.delete(employee);
        return "Deleted employee with id: ".concat(String.valueOf(employee.getId()));
    }
}
