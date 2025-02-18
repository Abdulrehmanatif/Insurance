package com.example.insurance.service.serviceImpl;

import com.example.insurance.dto.AddClaimRequestDTO;
import com.example.insurance.dto.ClaimResponseDTO;
import com.example.insurance.entity.Claim;
import com.example.insurance.exception.ClaimsNotFoundException;
import com.example.insurance.repository.ClaimRepository;
import com.example.insurance.service.ClaimService;
import com.example.insurance.utils.ApiResponse;
import com.example.insurance.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;

    @Override
    public ApiResponse addClaim(AddClaimRequestDTO request) {
        Claim claim = new Claim();
        claim.setClaimAmount(request.getClaimAmount());
        claim.setClaimDate(new Date());
        claim.setClaimStatus(request.getClaimStatus());
        claim.setClaimType(request.getClaimType());
        claim.setCustomerId(request.getCustomerId());
        claimRepository.save(claim);
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE);
    }

    @Override
    public ApiResponse updateClaimStatus(Integer claimId, Integer status) {
        Objects.requireNonNull(claimId, Constants.INVALID_CLAIM_ID);
        Objects.requireNonNull(status, Constants.INVALID_CLAIM_ID);
        claimRepository.updateClaimStatus(claimId, status);
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE);
    }

    @Override
    public ApiResponse deleteClaim(Integer claimId) {
        Objects.requireNonNull(claimId, Constants.INVALID_CLAIM_ID);
        claimRepository.deleteByClaimId(claimId);
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE);
    }

    @Override
    public ApiResponse getAllClaims(Integer customerId) throws Exception {
        List<Claim> claims = Optional.of(claimRepository.findAllByCustomerId(customerId))
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new ClaimsNotFoundException(customerId));
        List<ClaimResponseDTO> response = claims.stream().map(claim -> {
            ClaimResponseDTO claimResponseDTO = new ClaimResponseDTO();
            claimResponseDTO.setClaimId(claim.getClaimId());
            claimResponseDTO.setClaimAmount(claim.getClaimAmount().toString());
            claimResponseDTO.setClaimDate(claim.getClaimDate());
            claimResponseDTO.setCustomerId(claim.getCustomerId());
            claimResponseDTO.setClaimType(Constants.InsuranceTypeEnum.getDescriptionById(claim.getClaimType()));
            claimResponseDTO.setClaimStatus(Constants.ClaimStatusEnum.getDescriptionById(claim.getClaimStatus()));
            return claimResponseDTO;
        }).toList();
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, response);
    }
}
