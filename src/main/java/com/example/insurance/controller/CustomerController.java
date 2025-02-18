package com.example.insurance.controller;

import com.example.insurance.dto.AddCustomerRequestDTO;
import com.example.insurance.service.CustomerService;
import com.example.insurance.utils.ApiResponse;
import com.example.insurance.utils.Constants;
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
    public ResponseEntity<ApiResponse> addCustomer(@RequestBody AddCustomerRequestDTO request){
        log.info("InsuranceController.addCustomer");
        try {
            return new ResponseEntity<>(customerService.addCustomer(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(Constants.FAILURE_CODE, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-customer-info")
    public ResponseEntity<ApiResponse> getCustomerInfo(@RequestParam("customerId") Integer customerId) throws Exception {
        log.info("InsuranceController.getCustomerInfo");
        try {
            return new ResponseEntity<>(customerService.getCustomerInfo(customerId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(Constants.FAILURE_CODE, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
