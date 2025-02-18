package com.example.insurance.controller;

import com.example.insurance.dto.AddClaimRequestDTO;
import com.example.insurance.dto.AddCustomerRequestDTO;
import com.example.insurance.service.ClaimService;
import com.example.insurance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/insurance")
public class InsuranceController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ClaimService claimService;

    @PostMapping("/add-customer")
    public ResponseEntity<?> addCustomer(@RequestBody AddCustomerRequestDTO request){
        return new ResponseEntity<>(customerService.addCustomer(request), HttpStatus.OK);
    }

    @PostMapping("/add-claim")
    public ResponseEntity<?> addClaim(@RequestBody AddClaimRequestDTO request){
        return new ResponseEntity<>(claimService.addClaim(request), HttpStatus.OK);
    }

    @PutMapping("/update-claim")
    public ResponseEntity<?> updateClaim(@RequestParam("claimId") Integer claimId, @RequestParam("status") Integer status){
        return new ResponseEntity<>(claimService.updateClaimStatus(claimId, status), HttpStatus.OK);
    }

    @DeleteMapping("/delete-claim")
    public ResponseEntity<?> deleteClaim(@RequestParam("claimId") Integer claimId){
        return new ResponseEntity<>(claimService.deleteClaim(claimId), HttpStatus.OK);
    }

    @GetMapping("/get-all-claims")
    public ResponseEntity<?> getAllClaims(@RequestParam("customerId") Integer customerId){
        return new ResponseEntity<>(claimService.getAllClaims(customerId), HttpStatus.OK);
    }

    @GetMapping("/get-customer-info")
    public ResponseEntity<?> getCustomerInfo(@RequestParam("customerId") Integer customerId){
        return new ResponseEntity<>(customerService.getCustomerInfo(customerId), HttpStatus.OK);
    }
}
