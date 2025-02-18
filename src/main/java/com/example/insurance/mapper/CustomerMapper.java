package com.example.insurance.mapper;

import com.example.insurance.dto.AddCustomerRequest;
import com.example.insurance.dto.CustomerResponse;
import com.example.insurance.entity.Customer;
import com.example.insurance.utils.Constants;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomerEntity(AddCustomerRequest request) {
        Customer customer = new Customer();
        customer.setFullName(request.getFullName());
        customer.setBirthDate(request.getBirthDate());
        customer.setInsuranceType(request.getInsuranceTypes());
        return customer;
    }

    public CustomerResponse toCustomerResponseDTO(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.setCustomerId(customer.getCustomerId());
        response.setFullName(customer.getFullName());
        response.setBirthDate(customer.getBirthDate());
        response.setInsuranceTypes(Constants.InsuranceTypeEnum.getDescriptionById(customer.getInsuranceType()));
        return response;
    }
}

