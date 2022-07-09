package com.sv.customerlimits.dao;

import com.sv.customerlimits.entity.Customer;
import com.sv.customerlimits.entity.TransactionLimit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveNewCustomer() {
//        TransactionLimit limit = TransactionLimit.builder().dailyLimit(500).weeklyLimit(1500).monthlyLimit(5000).build();
//
//        Customer customer = Customer.builder().firstName("Joe").lastName("Sugg").email("joe@gmail.com").mobile("9231139933").transactionLimit(limit).build();
//
//        customerRepository.save(customer);
    }

}