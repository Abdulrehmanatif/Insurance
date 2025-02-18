package com.example.insurance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequestDTO {

    private String fullName;

    private List<Integer> insuranceTypes;

    private Date birthDate;
}
