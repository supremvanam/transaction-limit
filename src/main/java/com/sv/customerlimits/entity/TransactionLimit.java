package com.sv.customerlimits.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class TransactionLimit {

    @Id
    @SequenceGenerator(name = "limit_sequence", sequenceName = "limit_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "limit_sequence")
    private Long limitId;
    private Integer dailyLimit;
    private Integer weeklyLimit;
    private Integer monthlyLimit;
}
