package com.example.insurance.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CustomerResponse {
    private Integer customerId;
    private String fullName;
    private String insuranceTypes;
    private Date birthDate;
}
