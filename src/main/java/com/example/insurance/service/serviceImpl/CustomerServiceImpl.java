package com.example.insurance.service.serviceImpl;

import com.example.insurance.dto.AddCustomerRequest;
import com.example.insurance.dto.CustomerResponse;
import com.example.insurance.entity.Customer;
import com.example.insurance.exception.CustomerNotFoundException;
import com.example.insurance.mapper.CustomerMapper;
import com.example.insurance.repository.CustomerRepository;
import com.example.insurance.service.CustomerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse addCustomer(AddCustomerRequest request) {
        return customerMapper.toCustomerResponseDTO(customerRepository.save(customerMapper.toCustomerEntity(request)));
    }


    @Override
    public CustomerResponse getCustomerInfo( Integer customerId) {
        return customerMapper.toCustomerResponseDTO(customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not Found")));
    }
}
