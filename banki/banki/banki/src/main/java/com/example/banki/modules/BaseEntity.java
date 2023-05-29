package com.example.banki.modules;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BaseEntity {
    @Id
    @SequenceGenerator(initialValue = 100,name = "number")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "number")
    private int id ;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;


}