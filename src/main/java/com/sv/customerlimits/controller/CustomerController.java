package com.sv.customerlimits.controller;

import com.sv.customerlimits.entity.Customer;
import com.sv.customerlimits.response.CustomerResponse;
import com.sv.customerlimits.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customers")
    public List<Customer> fetchAllCustomers() {
        return customerService.fetchAllCustomers();
    }

    @PostMapping("/api/customers")
    public ResponseEntity<Object> addNewCustomer(@RequestBody Customer customer) {
        return customerService.addNewCustomer(customer);
    }

}
