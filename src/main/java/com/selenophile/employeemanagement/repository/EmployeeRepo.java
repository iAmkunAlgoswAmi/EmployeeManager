package com.selenophile.employeemanagement.repository;

import com.selenophile.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
