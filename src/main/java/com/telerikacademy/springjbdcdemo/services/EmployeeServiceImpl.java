package com.telerikacademy.springjbdcdemo.services;

import com.telerikacademy.springjbdcdemo.models.Employee;
import com.telerikacademy.springjbdcdemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Employee employee) {
        repository.create(employee);
    }

    @Override
    public List<Employee> getAll() {
        return repository.getAll();
    }

    @Override
    public Employee getById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Employee> getByJobTitle(String jobTitle) {
        return getByJobTitle(jobTitle);
    }

    @Override
    public void update(int id,Employee employee) {
        repository.update(id, employee);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
