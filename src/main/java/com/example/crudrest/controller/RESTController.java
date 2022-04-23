package com.example.crudrest.controller;

import com.example.crudrest.entity.Employee;
import com.example.crudrest.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private ServiceDAO serviceDAO;

    @GetMapping("/employees") // <- Return list of employees
    public List<Employee> getEmployees() {
        return serviceDAO.findAll();
    }

    @PostMapping("/employees") // <- Create employee
    public Employee createEmployee(@RequestBody Employee employee) {
        return serviceDAO.createEmployee(employee);
    }

    @GetMapping("/employees/{id}") // <- Read employee by ID
    public Employee readEmployee(@PathVariable int id) {
        return serviceDAO.readEmployee(id);
    }

    @PutMapping("/employees") // <- Update employee
    public Employee updateEmployee(@RequestBody Employee employee) {
        return serviceDAO.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}") // <- Delete employee by ID
    public String deleteEmployee(@PathVariable int id) {
        return serviceDAO.deleteEmployee(id);
    }
}
