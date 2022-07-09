package com.sv.customerlimits.service;

import com.sv.customerlimits.dao.CustomerRepository;
import com.sv.customerlimits.entity.Customer;
import com.sv.customerlimits.error.InvalidTransactionLimitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl("http://localhost:8081/api/limits").defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Object> addNewCustomer(Customer customer, Long id) {

        Mono<String> getLimit =  webClient.get().uri("http://localhost:8081/api/limits/"+id).retrieve().bodyToMono(String.class);
        System.out.println("getLimit is running: " + getLimit);

//        if (customer.getTransactionLimit().getDailyLimit() >= customer.getTransactionLimit().getWeeklyLimit() || customer.getTransactionLimit().getDailyLimit() >= customer.getTransactionLimit().getMonthlyLimit()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Daily limit must be lower than weekly and monthly transaction limit");
//        } else if (customer.getTransactionLimit().getWeeklyLimit() >= customer.getTransactionLimit().getMonthlyLimit()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Weekly limit must be lower than the monthly transaction limit");
//        }

        return ResponseEntity.status(HttpStatus.OK).body(customerRepository.save(customer));

    }

    public List<Customer> fetchAllCustomers() {
        return customerRepository.findAll();
    }

    public void removeCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public ResponseEntity<Object> fetchCustomerById(Long customerId) {

        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with ID: " + customerId + " does not exist"));
    }
}
