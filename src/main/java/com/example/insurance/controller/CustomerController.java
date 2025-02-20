package com.example.insurance.controller;

import com.example.insurance.dto.AddCustomerRequest;
import com.example.insurance.dto.CustomerResponse;
import com.example.insurance.service.CustomerService;
import com.example.insurance.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/add-customer")
    public ResponseEntity<ApiResponse<CustomerResponse>> addCustomer(@RequestBody AddCustomerRequest request) {
        return new ResponseEntity<>(customerService.addCustomer(request), HttpStatus.OK);
    }

    @GetMapping("/get-customer-info")
    public ResponseEntity<ApiResponse<CustomerResponse>> getCustomerInfo(@RequestParam("customerId") Integer customerId) {
        return new ResponseEntity<>(customerService.getCustomerInfo(customerId), HttpStatus.OK);
    }
}
