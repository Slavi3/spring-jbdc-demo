package com.telerikacademy.springjbdcdemo.controllers;

import com.telerikacademy.springjbdcdemo.models.Employee;
import com.telerikacademy.springjbdcdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeesRestController(EmployeeService service) {
        this.employeeService = service;
    }

    @PostMapping("/new")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.create(employee);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @GetMapping("/title/{jobTitle}")
    List<Employee> findByName(@PathVariable String jobTitle) {
        return employeeService.getByJobTitle(jobTitle);
    }

    @PutMapping
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.update(id, employee);
    }
    @DeleteMapping
    public void deleteEMployee(@PathVariable int id){
        employeeService.delete(id);
    }
}
