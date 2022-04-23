package com.example.crudrest.dao.repository;

import com.example.crudrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> { // <- Entity type, Primary key type

}
