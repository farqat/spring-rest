package com.farqat.springrest.controller;


import com.farqat.springrest.entity.Employee;
import com.farqat.springrest.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(description = "Get all employees", summary = "")
    @GetMapping("employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @Operation(description = "Add employees", summary = "")
    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @Operation(description = "Get employee by id", summary = "")
    @Parameter(name = "id", description = "Employee ID", required = true)
    @GetMapping("employee/{id}")
    public Employee getEmploeeById(@PathVariable("id") long id){
        return employeeService.getEmployeeById(id);
    }

    @Operation(description = "Delete employee by id", summary = "")
    @Parameter(name = "id", description = "Employee ID", required = true)
    @DeleteMapping("employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") long id){
        return employeeService.deleteEmployeeById(id);
    }

    @Operation(description = "Edit employees", summary = "")
    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

}
