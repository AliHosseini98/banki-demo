package com.example.banki.modules.customer.model;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table
public class Customer  {


    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String family;
    private boolean enabled = true;
    private String phoneNumber;
    private Long card_id;

    @Email
    private String email;

    public Customer(String name, String family, String phoneNumber, Long card_id, String email) {
        this.name = name;
        this.family = family;
        this.phoneNumber = phoneNumber;
        this.card_id = card_id;
        this.email = email;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Long getCard_id() {
        return card_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }


    public void setEnabled(boolean status) {
        this.enabled = status;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCard_id(Long card_id) {
        this.card_id = card_id;
    }
}

