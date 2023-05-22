package com.example.banki.modules.customer.service;

import com.example.banki.modules.customer.model.Customer;
import com.example.banki.modules.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService (CustomerRepository customerRepository){
        this.customerRepository= customerRepository;
    }

    public Customer save (Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer){
        Customer update_customer = customerRepository.findById(customer.getId()).orElseThrow(()-> new RuntimeException("The entered ID is not available"));
        update_customer.setCard_id(customer.getCard_id());
        update_customer.setEmail(customer.getEmail());
        update_customer.setName(customer.getName());
        update_customer.setPhoneNumber(customer.getPhoneNumber());
        update_customer.setFamily(customer.getFamily());
        return customerRepository.save(update_customer);
    }

    public void delete (int id){
        customerRepository.deleteById(id);
    }


    public List<Customer> getAllCustomers(){
       return customerRepository.findAll();
    }
}
