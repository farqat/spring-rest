package com.farqat.springrest.service;

import com.farqat.springrest.entity.Employee;
import com.farqat.springrest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public String deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
        return "Employee with id: " + id + " was deleted";
    }

    public Employee updateEmployee(Employee employee) {
        Employee employeeExists = employeeRepository.findById(employee.getEmpid()).orElse(null);
        employeeExists.setFirstName(employee.getFirstName());
        employeeExists.setLastName(employee.getLastName());
        employeeExists.setEmail(employee.getEmail());
        return employeeRepository.save(employeeExists);
    }
}
