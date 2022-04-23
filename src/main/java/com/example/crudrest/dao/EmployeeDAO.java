package com.example.crudrest.dao;

import com.example.crudrest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee createEmployee(Employee employee);
    Employee readEmployee(int id);
    Employee updateEmployee(Employee employee);
    String deleteEmployee(int id);
}
