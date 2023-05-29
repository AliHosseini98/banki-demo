package com.example.banki.modules.employee.model;
import com.example.banki.modules.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table
public class Employee extends BaseEntity {


    @NotBlank(message = "name shouldn't be null")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = " Do not use characters ")
    private String name;
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = " Do not use characters ")
    @NotBlank(message = "family shouldn't be null")
    private String family;

}