package com.example.insurance.dto;


import lombok.Data;

import java.util.Date;

@Data
public class ClaimResponse {
    private Integer claimId;
    private Integer customerId;
    private String claimType;
    private Date claimDate;
    private String claimStatus;
    private String claimAmount;
}
