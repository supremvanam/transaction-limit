package com.sv.customerlimits.entity;

import com.sv.customerlimits.client.TLModel;
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
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Long limitId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(
//            name = "limit_id",
//            referencedColumnName = "limitId"
//
//    )
//    private TransactionLimit transactionLimit;
}
