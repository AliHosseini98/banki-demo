package com.example.banki.modules.account.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private int accNumber;
    private double currentBalance;
    private String author;
    private String bankBranch;
    private LocalDateTime dateTime;

}
