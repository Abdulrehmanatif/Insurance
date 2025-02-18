package com.example.insurance.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

    private Integer customerId;

    private String fullName;

    private List<String> insuranceTypes;

    private Date birthDate;
}
