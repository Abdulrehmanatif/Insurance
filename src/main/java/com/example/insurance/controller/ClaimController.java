package com.example.insurance.controller;

import com.example.insurance.dto.AddClaimRequest;
import com.example.insurance.dto.ClaimResponse;
import com.example.insurance.service.ClaimService;
import com.example.insurance.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController("/claim")
public class ClaimController {
    private final ClaimService claimService;

    @PostMapping("/add-claim")
    public ResponseEntity<ClaimResponse> addClaim(@RequestBody AddClaimRequest request){
        return new ResponseEntity<>(claimService.addClaim(request), HttpStatus.OK);
    }

    @PutMapping("/update-claim")
    public ResponseEntity<ApiResponse> updateClaim(@RequestParam("claimId") Integer claimId,
                                                   @RequestParam("status") Integer status){
        return new ResponseEntity<>(claimService.updateClaimStatus(claimId, status), HttpStatus.OK);
    }

    @DeleteMapping("/delete-claim")
    public ResponseEntity<ApiResponse> deleteClaim(@RequestParam("claimId") Integer claimId){
        return new ResponseEntity<>(claimService.deleteClaim(claimId), HttpStatus.OK);
    }

    @GetMapping("/get-all-claims")
    public ResponseEntity<List<ClaimResponse>> getAllClaims(@RequestParam("customerId") Integer customerId){
        return new ResponseEntity<>(claimService.getAllClaims(customerId), HttpStatus.OK);
    }
}
