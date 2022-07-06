package com.sv.customerlimits.dao;

import com.sv.customerlimits.entity.TransactionLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionLimitRepository extends JpaRepository<TransactionLimit, Long> {
}
