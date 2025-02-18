package com.example.insurance.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddClaimRequestDTO {

    private Integer customerId;

    private Integer claimType;

    private Integer claimStatus;

    private BigDecimal claimAmount;
}
