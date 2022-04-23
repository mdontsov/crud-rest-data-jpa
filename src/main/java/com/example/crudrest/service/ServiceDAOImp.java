package com.example.crudrest.service;

import com.example.crudrest.dao.repository.EmployeeRepo;
import com.example.crudrest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDAOImp implements ServiceDAO {

    // JpaRepository methods: DATA JPA (V3) - no implementation classes required!

    private final EmployeeRepo employeeRepo;

    @Autowired
    public ServiceDAOImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee readEmployee(int id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepo.deleteById(id);
        return "Deleted employee with id: " + id;
    }
}
