package com.example.banki.modules.employee;

import com.example.banki.modules.employee.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeConvertor {
    public EmployeeDTO entityToDto(Employee employee){
         EmployeeDTO dto = EmployeeDTO.build(employee.getId(),employee.getName(),employee.getFamily());
         return dto;
    }

    public List<EmployeeDTO> employeeDTOList (List<Employee> employees){
        return employees.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }
}
