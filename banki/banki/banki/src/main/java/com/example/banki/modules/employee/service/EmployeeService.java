package com.example.banki.modules.employee.service;
import com.example.banki.modules.employee.EmployeeConvertor;
import com.example.banki.modules.employee.EmployeeDTO;
import com.example.banki.modules.employee.model.Employee;
import com.example.banki.modules.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeConvertor employeeConvertor;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeConvertor employeeConvertor) {
        this.employeeRepository = employeeRepository;
        this.employeeConvertor = employeeConvertor;
    }


    public EmployeeDTO save(Employee employee){
        this.employeeRepository.save(employee);
        return employeeConvertor.entityToDto(employee);
    }


}
