package com.example.insurance.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
public class AddCustomerRequestDTO {

    @NotNull(message = "Full name cannot be null")
    @NotEmpty(message = "Full name cannot be empty")
    private String fullName;

    @NotNull(message = "Insurance types cannot be null")
    @NotEmpty(message = "At least one insurance type must be provided")
    private List<Integer> insuranceTypes;

    @NotNull(message = "Birth date cannot be null")
    private Date birthDate;
}
