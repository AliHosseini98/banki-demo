package com.example.banki.modules.customer.controller;

import com.example.banki.modules.customer.CustomerDTO;
import com.example.banki.modules.customer.model.Customer;
import com.example.banki.modules.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//5555555555555555

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//44444444

import javax.validation.Valid;
import java.util.List;
@CrossOrigin

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    private CustomerService customerService;
    private final HttpServletRequest request;

    @Autowired
    public CustomerController(CustomerService customerService, HttpServletRequest request) {
        this.customerService = customerService;
        this.request = request;
    }

    @CrossOrigin
    @PostMapping("/new")
    public ResponseEntity<CustomerDTO> registerCustomer(@Valid @RequestBody Customer customer) {
        String ipAddress = request.getRemoteAddr();
        log.info("User IP Address: {}", ipAddress);
        log.info("this object created" + customer);
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.update(customer), HttpStatus.CREATED);
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
    @PutMapping("/block/{cusId}")
    public void Blocked(@PathVariable int cusId) {
        customerService.blockedCustomer(cusId);
    }

    //move to cus
    @PutMapping("/unblock/{cusId}")
    public void unBlocked(@PathVariable int cusId) {
        customerService.unBlockCustomer(cusId);
    }


}
