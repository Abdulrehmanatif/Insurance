package com.example.insurance.controller;

import com.example.insurance.dto.AddClaimRequestDTO;
import com.example.insurance.dto.AddCustomerRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/insurance")
public class InsuranceController {

    @PostMapping("/add-customer")
    public ResponseEntity<?> addCustomer(@RequestBody AddCustomerRequestDTO request){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @PostMapping("/add-claim")
    public ResponseEntity<?> addClaim(@RequestBody AddClaimRequestDTO request){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @PutMapping("/update-claim")
    public ResponseEntity<?> updateClaim(@RequestParam("claimId") Integer claimId, @RequestParam("status") Integer status){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @DeleteMapping("/delete-claim")
    public ResponseEntity<?> deleteClaim(@RequestParam("claimId") Integer claimId){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/get-all-claims")
    public ResponseEntity<?> getAllClaims(@RequestParam("customerId") Integer customerId){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/get-customer-info")
    public ResponseEntity<?> getCustomerInfo(@RequestParam("customerId") Integer customerId){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
