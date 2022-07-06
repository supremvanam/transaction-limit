package com.sv.customerlimits.service;

import com.sv.customerlimits.dao.CustomerRepository;
import com.sv.customerlimits.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
