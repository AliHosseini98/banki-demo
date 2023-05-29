package com.example.banki.modules.bankBranch;

import com.example.banki.modules.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor(staticName = "build")
public class BankBranchDTO {
    private int id;
    private String name;
    private String address;
    private List<Employee> employees;

}
