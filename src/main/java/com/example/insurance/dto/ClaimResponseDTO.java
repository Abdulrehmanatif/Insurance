package com.example.insurance.dto;


import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ClaimResponseDTO {

    private Integer claimId;

    private Integer customerId;

    private String claimType;

    private Date claimDate;

    private String claimStatus;

    private String claimAmount;
}
