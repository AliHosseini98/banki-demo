package com.example.banki.modules.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "build")
public class EmployeeDTO {
    private int id;
    private String name;
    private String family;
}

