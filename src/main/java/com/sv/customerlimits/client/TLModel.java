package com.sv.customerlimits.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TLModel {
    private Long limitId;
    private Integer dailyLimit;
    private Integer weeklyLimit;
    private Integer monthlyLimit;
}
