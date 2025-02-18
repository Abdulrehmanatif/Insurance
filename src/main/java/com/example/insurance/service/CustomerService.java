package com.example.insurance.service;


import com.example.insurance.dto.AddCustomerRequestDTO;
import com.example.insurance.utils.ApiResponse;

public interface CustomerService {

    public ApiResponse addCustomer(AddCustomerRequestDTO request);

    public ApiResponse getCustomerInfo(Integer customerId);

}
