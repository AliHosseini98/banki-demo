package com.example.banki.modules.customer;

import com.example.banki.modules.account.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.List;
@Data
@AllArgsConstructor(staticName = "build")

public class CustomerDTO {
    private int id;
    private Long card_id;
    private String name;
    private String family;
    private String phoneNumber;
    private String email;

}
