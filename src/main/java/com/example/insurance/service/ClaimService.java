package com.example.insurance.service;

import com.example.insurance.dto.AddClaimRequest;
import com.example.insurance.dto.ClaimResponse;
import com.example.insurance.utils.ApiResponse;

import java.util.List;

public interface ClaimService {

    public ClaimResponse addClaim(AddClaimRequest request);

    public ApiResponse updateClaimStatus(Integer claimId, Integer status);

    public ApiResponse deleteClaim(Integer claimId);

    public List<ClaimResponse> getAllClaims(Integer customerId);

}
