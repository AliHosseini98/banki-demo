package com.example.banki.modules.bankBranch.model;

import com.example.banki.modules.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BankBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    @OneToMany
    private List<Employee> employees;

    public void addEmployee(Employee employee) {
        if (employee == null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }



}
