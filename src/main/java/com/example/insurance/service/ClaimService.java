package com.example.insurance.service;

import com.example.insurance.dto.AddClaimRequestDTO;
import com.example.insurance.utils.ApiResponse;
import org.springframework.web.bind.annotation.RequestParam;

public interface ClaimService {

    public ApiResponse addClaim(AddClaimRequestDTO request);

    public ApiResponse updateClaimStatus(Integer claimId, Integer status);

    public ApiResponse deleteClaim(Integer claimId);

    public ApiResponse getAllClaims(Integer customerId);

}
