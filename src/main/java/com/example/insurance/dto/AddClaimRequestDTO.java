package com.example.insurance.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
public class AddClaimRequestDTO {

    @NotNull(message = "Customer ID cannot be null")
    private Integer customerId;

    @NotNull(message = "Claim type cannot be null")
    private Integer claimType;

    @NotNull(message = "Claim status cannot be null")
    private Integer claimStatus;

    @NotNull(message = "Claim amount cannot be null")
    private BigDecimal claimAmount;
}
