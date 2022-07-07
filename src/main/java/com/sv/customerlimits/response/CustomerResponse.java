package com.sv.customerlimits.response;

import com.sv.customerlimits.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse<T> {
    private Customer customer;
    private ResponseEntity<String> status;
}
