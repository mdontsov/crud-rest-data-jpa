package com.example.crudrest.dao.repository;

import com.example.crudrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Now with DATA REST no Controller, DAO and Service Implementation required
// By default Spring will create endpoints based on Entity type - first character of Entity in lowercase + "s" at the end
@RepositoryRestResource(path = "members") // <- Custom endpoint name, /employees -> /members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { // <- Entity type, Primary key type

}
