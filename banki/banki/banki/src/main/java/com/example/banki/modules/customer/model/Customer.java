package com.example.banki.modules.customer.model;

import com.example.banki.modules.account.model.Account;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Customer {


    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "username shouldn't be null")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = " Do not use characters ")
    private String name;
    @NotBlank(message = "family shouldn't be null")
    private String family;
    private boolean enabled = true;
    @Pattern(regexp = "^09\\d{9}$", message = "invalid mobile number entered ")
    private String phoneNumber;


    @Min(value = 999999999, message = "The national number must contain 10 numbers ")
    @Max(value = 10000000000L, message = "The national number must contain 10 numbers ")
    private Long card_id;


    @Column(unique = true)
    @Email(message = "invalid email address")
    private String email;


    @OneToMany
    private List<Account> accounts;


}