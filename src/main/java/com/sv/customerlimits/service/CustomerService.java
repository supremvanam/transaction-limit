package com.sv.customerlimits.service;

import com.sv.customerlimits.dao.CustomerRepository;
import com.sv.customerlimits.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Object> addNewCustomer(Customer customer) {

        if (customer.getTransactionLimit().getDailyLimit() > customer.getTransactionLimit().getWeeklyLimit() || customer.getTransactionLimit().getDailyLimit() > customer.getTransactionLimit().getMonthlyLimit()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Daily limit must be lower than weekly and monthly transaction limit");
        } else if (customer.getTransactionLimit().getWeeklyLimit() > customer.getTransactionLimit().getMonthlyLimit()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Weekly limit must be lower than the monthly transaction limit");

        }
        return ResponseEntity.status(HttpStatus.OK).body(customerRepository.save(customer));

    }

    public List<Customer> fetchAllCustomers() {
        return customerRepository.findAll();
    }
}
