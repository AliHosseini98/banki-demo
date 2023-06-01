package com.example.banki.modules.customer.controller;

import com.example.banki.modules.customer.CustomerDTO;
import com.example.banki.modules.customer.model.Customer;
import com.example.banki.modules.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/new")
    public ResponseEntity<CustomerDTO> registerCustomer(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.update(customer),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/customers")
    @ResponseBody
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    //move to cus
    @PutMapping ("/unblock/{cusId}")
    public void accountBlocked(@PathVariable int cusId) {
        customerService.accountBlocked(cusId);
    }

    //move to cus
    @PutMapping("/block/{cusId}")
    public void accountUnblocked(@PathVariable int cusId) {
        customerService.unblockAccount(cusId);
    }


}
