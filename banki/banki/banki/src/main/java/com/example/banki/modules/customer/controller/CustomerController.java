package com.example.banki.modules.customer.controller;

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
    public CustomerController(CustomerService customerService){
        this.customerService= customerService;}


    @PostMapping("/new")
    public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer){
        return  new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer (@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.update(customer));}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/customers")
    @ResponseBody
    public List<Customer> getAllCustomers(){
      return   customerService.getAllCustomers();
    }

}
