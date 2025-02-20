package com.example.insurance.service;

import com.example.insurance.dto.AddClaimRequest;
import com.example.insurance.dto.ClaimResponse;
import com.example.insurance.utils.ApiResponse;

import java.util.List;

public interface ClaimService {

    public ApiResponse<ClaimResponse> addClaim(AddClaimRequest request);

    public ApiResponse<ClaimResponse> updateClaimStatus(Integer claimId, Integer status);

    public ApiResponse<?> deleteClaim(Integer claimId);

    public ApiResponse<List<ClaimResponse>> getAllClaims(Integer customerId);

}
