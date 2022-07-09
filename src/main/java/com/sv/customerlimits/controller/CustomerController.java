package com.sv.customerlimits.controller;

import com.sv.customerlimits.entity.Customer;
import com.sv.customerlimits.response.CustomerResponse;
import com.sv.customerlimits.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> fetchAllCustomers() {
        return customerService.fetchAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchCustomerById(@PathVariable(value = "id") Long customerId) {
        return customerService.fetchCustomerById(customerId);
    }

    @PostMapping
    public ResponseEntity<Object> addNewCustomer(@RequestBody Customer customer) {
        return customerService.addNewCustomer(customer, customer.getLimitId());
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable(value = "id") Long customerId) {
        customerService.removeCustomer(customerId);
    }

}
