package com.example.banki.modules.customer.service;

import com.example.banki.modules.customer.CustomerConvertor;
import com.example.banki.modules.customer.CustomerDTO;
import com.example.banki.modules.customer.model.Customer;
import com.example.banki.modules.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    private final CustomerConvertor convertor;

    public CustomerService(CustomerRepository customerRepository, CustomerConvertor convertor) {
        this.customerRepository = customerRepository;
        this.convertor = convertor;
    }

    //check method for insert id for search
    public CustomerDTO save(Customer customer) {
        customerRepository.save(customer);
        return convertor.entityToDto(customer);

    }

    //check method
    public CustomerDTO update(Customer customer) {
        Customer update_customer = customerRepository.findById(customer.getId()).orElseThrow(() -> new RuntimeException("The entered ID is not available"));
        update_customer.setCard_id(customer.getCard_id());
        update_customer.setEmail(customer.getEmail());
        update_customer.setName(customer.getName());
        update_customer.setPhoneNumber(customer.getPhoneNumber());
        update_customer.setFamily(customer.getFamily());
        CustomerDTO dto = convertor.entityToDto(update_customer);
        customerRepository.save(update_customer);
        return dto;
    }

    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOList = convertor.customerDTOList(customerRepository.findAll());
        return customerDTOList;
    }

    public void accountBlocked(int cusId) {
        Customer bl = customerRepository.findById(cusId).get();
        bl.setEnabled(false);
        customerRepository.save(bl);
    }

    public void unblockAccount(int cusId) {
        Customer unbl = customerRepository.findById(cusId).get();
        unbl.setEnabled(true);
        customerRepository.save(unbl);
    }

}
