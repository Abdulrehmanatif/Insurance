package com.example.insurance.service;


import com.example.insurance.dto.AddCustomerRequest;
import com.example.insurance.dto.CustomerResponse;
import com.example.insurance.utils.ApiResponse;

public interface CustomerService {

    public CustomerResponse addCustomer(AddCustomerRequest request);

    public CustomerResponse getCustomerInfo(Integer customerId);

}
