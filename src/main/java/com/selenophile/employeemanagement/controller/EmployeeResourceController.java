package com.selenophile.employeemanagement.controller;

import com.selenophile.employeemanagement.model.Employee;
import com.selenophile.employeemanagement.service.EmployeeRepoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResourceController {
    private final EmployeeRepoService employeeRepoService;

    public EmployeeResourceController(EmployeeRepoService employeeRepoService) {
        this.employeeRepoService = employeeRepoService;
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeRepoService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employees = employeeRepoService.addEmployee(employee);
        return new ResponseEntity<>(employees, HttpStatus.CREATED);
    }
}
