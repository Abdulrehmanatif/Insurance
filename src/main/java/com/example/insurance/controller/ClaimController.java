package com.example.insurance.controller;

import com.example.insurance.dto.AddClaimRequestDTO;
import com.example.insurance.service.ClaimService;
import com.example.insurance.utils.ApiResponse;
import com.example.insurance.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController("/claim")
public class ClaimController {

    private final ClaimService claimService;

    @PostMapping("/add-claim")
    public ResponseEntity<ApiResponse> addClaim(@RequestBody AddClaimRequestDTO request){
        log.info("InsuranceController.addClaim");
        try {
            return new ResponseEntity<>(claimService.addClaim(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(Constants.FAILURE_CODE, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-claim")
    public ResponseEntity<ApiResponse> updateClaim(@RequestParam("claimId") Integer claimId, @RequestParam("status") Integer status){
        log.info("InsuranceController.updateClaim");
        try {
            return new ResponseEntity<>(claimService.updateClaimStatus(claimId, status), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(Constants.FAILURE_CODE, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-claim")
    public ResponseEntity<ApiResponse> deleteClaim(@RequestParam("claimId") Integer claimId){
        log.info("InsuranceController.deleteClaim");
        try {
            return new ResponseEntity<>(claimService.deleteClaim(claimId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(Constants.FAILURE_CODE, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-claims")
    public ResponseEntity<ApiResponse> getAllClaims(@RequestParam("customerId") Integer customerId) throws Exception {
        log.info("InsuranceController.getAllClaims");
        try {
            return new ResponseEntity<>(claimService.getAllClaims(customerId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(Constants.FAILURE_CODE, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
