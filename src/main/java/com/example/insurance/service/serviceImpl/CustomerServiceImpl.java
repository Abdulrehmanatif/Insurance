package com.example.insurance.service.serviceImpl;

import com.example.insurance.dto.AddCustomerRequest;
import com.example.insurance.dto.CustomerResponse;
import com.example.insurance.entity.Customer;
import com.example.insurance.exception.CustomerNotFoundException;
import com.example.insurance.mapper.CustomerMapper;
import com.example.insurance.repository.CustomerRepository;
import com.example.insurance.service.CustomerService;
import com.example.insurance.utils.ApiResponse;
import com.example.insurance.utils.Constants;
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
    public ApiResponse<CustomerResponse> addCustomer(AddCustomerRequest request) {
        log.info("Adding new customer: {}", request);
        Customer savedCustomer = customerRepository.save(customerMapper.toCustomerEntity(request));
        log.info("Customer added successfully with ID: {}", savedCustomer.getCustomerId());
        return new ApiResponse<>(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, customerMapper.toCustomerResponseDTO(savedCustomer));
    }

    @Override
    public ApiResponse<CustomerResponse> getCustomerInfo(Integer customerId) {
        log.info("Fetching customer info for ID: {}", customerId);
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> {
                    log.error("Customer with ID {} not found", customerId);
                    return new CustomerNotFoundException("Customer not Found");
                });
        log.info("Customer found: {}", customer);
        return new ApiResponse<>(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, customerMapper.toCustomerResponseDTO(customer));
    }
}
