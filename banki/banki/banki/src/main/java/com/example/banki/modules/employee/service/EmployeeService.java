package com.example.banki.modules.employee.service;
import com.example.banki.modules.employee.model.Employee;
import com.example.banki.modules.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee save(Employee employee){
       return this.employeeRepository.save(employee);
    }


}
