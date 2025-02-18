package com.example.insurance.mapper;

import com.example.insurance.dto.AddClaimRequest;
import com.example.insurance.dto.ClaimResponse;
import com.example.insurance.entity.Claim;
import com.example.insurance.utils.Constants;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClaimMapper {

    public Claim toClaim(AddClaimRequest request) {
        Claim claim = new Claim();
        claim.setClaimAmount(request.getClaimAmount());
        claim.setClaimDate(new Date());
        claim.setClaimStatus(request.getClaimStatus());
        claim.setClaimType(request.getClaimType());
        claim.setCustomerId(request.getCustomerId());
        return claim;
    }

    public ClaimResponse toClaimResponseDTO(Claim claim) {
        ClaimResponse responseDTO = new ClaimResponse();
        responseDTO.setClaimId(claim.getClaimId());
        responseDTO.setCustomerId(claim.getCustomerId());
        responseDTO.setClaimType(Constants.InsuranceTypeEnum.getDescriptionById(claim.getClaimType()));
        responseDTO.setClaimDate(claim.getClaimDate());
        responseDTO.setClaimStatus(Constants.ClaimStatusEnum.getDescriptionById(claim.getClaimStatus()));
        responseDTO.setClaimAmount(claim.getClaimAmount().toString());

        return responseDTO;
    }

    public ClaimResponse toClaimResponse(Claim claim) {
        ClaimResponse responseDTO = new ClaimResponse();
        responseDTO.setClaimId(claim.getClaimId());
        responseDTO.setCustomerId(claim.getCustomerId());
        responseDTO.setClaimAmount(claim.getClaimAmount().toString());
        responseDTO.setClaimDate(claim.getClaimDate());
        responseDTO.setClaimType(Constants.InsuranceTypeEnum.getDescriptionById(claim.getClaimType()));
        responseDTO.setClaimStatus(Constants.ClaimStatusEnum.getDescriptionById(claim.getClaimStatus()));

        return responseDTO;
    }

    public List<ClaimResponse> toClaimResponseDTOList(List<Claim> claims) {
        return claims.stream()
                .map(this::toClaimResponseDTO)
                .collect(Collectors.toList());
    }
}
