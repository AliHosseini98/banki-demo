package com.example.banki.modules.transaction;

import com.example.banki.modules.account.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class TransactionDTO {
//    String type;
    UUID transactionId;
    String source;
    String destination;
    String amount;
    LocalDateTime creationDate;

}
