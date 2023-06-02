package com.example.banki.modules.employee.service;
import com.example.banki.modules.employee.EmployeeConvertor;
import com.example.banki.modules.employee.EmployeeDTO;
import com.example.banki.modules.employee.model.Employee;
import com.example.banki.modules.employee.repository.EmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final PasswordEncoder passwordEncoder;

    private final EmployeeRepository employeeRepository;
    private final EmployeeConvertor employeeConvertor;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeConvertor employeeConvertor, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.employeeConvertor = employeeConvertor;
        this.passwordEncoder = passwordEncoder;
    }


    public EmployeeDTO save(Employee employee){
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        this.employeeRepository.save(employee);
        return employeeConvertor.entityToDto(employee);
    }


}
