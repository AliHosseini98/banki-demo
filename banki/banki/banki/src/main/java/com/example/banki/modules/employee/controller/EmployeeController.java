package com.example.banki.modules.employee.controller;

import com.example.banki.modules.employee.EmployeeDTO;
import com.example.banki.modules.employee.model.Employee;
import com.example.banki.modules.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<EmployeeDTO> save (@Valid @RequestBody  Employee employee){
        return  new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }


}
