package com.sv.customerlimits.controller;

import com.sv.customerlimits.entity.Customer;
import com.sv.customerlimits.entity.TransactionLimit;
import com.sv.customerlimits.service.TransactionLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionLimitController {

    private TransactionLimitService transactionLimitService;

    @Autowired
    public TransactionLimitController(TransactionLimitService transactionLimitService) {
        this.transactionLimitService = transactionLimitService;
    }

//    @PostMapping("/api/limits")
//    public TransactionLimit addNewLimit(@RequestBody TransactionLimit limit) {
//        return transactionLimitService.addNewLimit(limit);
//    }

}
