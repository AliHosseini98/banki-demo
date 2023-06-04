package com.example.banki.modules.customer;

import com.example.banki.modules.customer.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerConvertor {

    public CustomerDTO entityToDto(Customer customer){
        CustomerDTO dto = CustomerDTO.build(customer.getId(),customer.getCard_id(),
                customer.getName(),
                customer.getFamily(),customer.getPhoneNumber(),customer.getEmail());
        return dto;

    }

    public List<CustomerDTO> customerDTOList (List<Customer> customerList){
        return customerList.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }
}
