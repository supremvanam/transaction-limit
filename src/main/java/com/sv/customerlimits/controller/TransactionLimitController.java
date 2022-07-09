package com.sv.customerlimits.controller;

import com.sv.customerlimits.service.TransactionLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionLimitController {

    @Autowired
    public TransactionLimitController(TransactionLimitService transactionLimitService) {
    }

//    @PostMapping("/api/limits")
//    public TransactionLimit addNewLimit(@RequestBody TransactionLimit limit) {
//        return transactionLimitService.addNewLimit(limit);
//    }

}
