package com.farqat.springrest.controller;


import com.farqat.springrest.entity.Employee;
import com.farqat.springrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("employee/{id}")
    public Employee getEmploeeById(@PathVariable("id") long id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") long id){
        return employeeService.deleteEmployeeById(id);
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

}
