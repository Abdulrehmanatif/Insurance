package com.example.insurance.service.serviceImpl;

import com.example.insurance.dto.AddClaimRequestDTO;
import com.example.insurance.dto.ClaimResponseDTO;
import com.example.insurance.entity.Claim;
import com.example.insurance.entity.ClaimStatus;
import com.example.insurance.entity.InsuranceType;
import com.example.insurance.repository.ClaimRepository;
import com.example.insurance.repository.ClaimStatusRepository;
import com.example.insurance.repository.InsuranceTypeRepository;
import com.example.insurance.service.ClaimService;
import com.example.insurance.utils.ApiResponse;
import com.example.insurance.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    InsuranceTypeRepository insuranceTypeRepository;

    @Autowired
    ClaimStatusRepository claimStatusRepository;

    @Override
    public ApiResponse addClaim(AddClaimRequestDTO request) {
        Claim claim = new Claim();
        if (request.getClaimAmount() != null) {
            claim.setClaimAmount(request.getClaimAmount());
        } else {
            throw new IllegalArgumentException("Claim amount cannot be null");
        }
        claim.setClaimDate(new Date());
        if (request.getClaimStatus() != null) {
            claim.setClaimStatus(request.getClaimStatus());
        } else {
            throw new IllegalArgumentException("Claim status cannot be null");
        }
        if (request.getClaimType() != null) {
            claim.setClaimType(request.getClaimType());
        } else {
            throw new IllegalArgumentException("Claim type cannot be null");
        }
        if (request.getCustomerId() != null) {
            claim.setCustomerId(request.getCustomerId());
        } else {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        claimRepository.save(claim);
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, null);
    }

    @Override
    public ApiResponse updateClaimStatus(Integer claimId, Integer status) {
        if(claimId != null && status != null) { claimRepository.updateClaimStatus(claimId, status); }
        else { throw new IllegalArgumentException("Claim ID or status cannot be null"); }
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, null);
    }

    @Override
    public ApiResponse deleteClaim(Integer claimId) {
        if(claimId != null){ claimRepository.deleteByClaimId(claimId); }
        else{ throw new IllegalArgumentException("Claim ID cannot be null"); }
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, null);
    }

    @Override
    public ApiResponse getAllClaims(Integer customerId) throws Exception {
        List<Claim> claims = claimRepository.findAllByCustomerId(customerId);
        List<ClaimResponseDTO> response = new ArrayList<>();
        if(!claims.isEmpty()) {
            for (Claim claim : claims) {
                ClaimResponseDTO claimResponseDTO = new ClaimResponseDTO();
                claimResponseDTO.setClaimId(claim.getClaimId());
                claimResponseDTO.setClaimAmount(claim.getClaimAmount().toString());
                claimResponseDTO.setClaimDate(claim.getClaimDate());
                claimResponseDTO.setCustomerId(claim.getCustomerId());
                ClaimStatus claimStatus = claimStatusRepository.findById(claim.getClaimStatus()).get();
                claimResponseDTO.setClaimStatus(claimStatus.getStatusDescription());
                InsuranceType insuranceType = insuranceTypeRepository.findById(claim.getClaimType()).get();
                claimResponseDTO.setClaimType(insuranceType.getInsuranceTypeName());
                response.add(claimResponseDTO);
            }
        }else {
            throw new Exception("Claims Not Found!");
        }
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, response);
    }
}
