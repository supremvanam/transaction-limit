package com.sv.customerlimits.service;

import com.sv.customerlimits.dao.TransactionLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionLimitService {

    private TransactionLimitRepository transactionLimitRepository;

    @Autowired
    public TransactionLimitService(TransactionLimitRepository transactionLimitRepository) {
        this.transactionLimitRepository = transactionLimitRepository;
    }

}
