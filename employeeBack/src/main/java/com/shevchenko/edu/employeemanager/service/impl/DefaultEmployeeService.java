package com.shevchenko.edu.employeemanager.service.impl;

import com.shevchenko.edu.employeemanager.exception.EmployeeNotFoundException;
import com.shevchenko.edu.employeemanager.model.Employee;
import com.shevchenko.edu.employeemanager.repository.EmployeeRepository;
import com.shevchenko.edu.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DefaultEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee add(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id " + id + " was not found"));
    }
}
