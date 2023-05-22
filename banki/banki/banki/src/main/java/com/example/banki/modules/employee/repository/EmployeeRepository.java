package com.example.banki.modules.employee.repository;

import com.example.banki.modules.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
