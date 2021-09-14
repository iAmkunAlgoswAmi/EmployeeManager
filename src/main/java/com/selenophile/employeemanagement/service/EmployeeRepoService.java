package com.selenophile.employeemanagement.service;

import com.selenophile.employeemanagement.model.Employee;
import com.selenophile.employeemanagement.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeRepoService {
    private EmployeeRepo employeeRepo;
    public EmployeeRepoService() {
    }
    @Autowired
    public EmployeeRepoService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee deleteEmployee(Long id) {
        return employeeRepo.deleteEmployeeById(id).orElseThrow(()-> new RuntimeException("User Not Found with Id -> " + id ));
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()-> new RuntimeException("User Not Found With Id -> " + id));
    }

}
