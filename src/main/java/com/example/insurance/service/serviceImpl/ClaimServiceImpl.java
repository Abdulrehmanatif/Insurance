package com.example.insurance.service.serviceImpl;

import com.example.insurance.dto.AddClaimRequest;
import com.example.insurance.dto.ClaimResponse;
import com.example.insurance.exception.ClaimsNotFoundException;
import com.example.insurance.mapper.ClaimMapper;
import com.example.insurance.repository.ClaimRepository;
import com.example.insurance.service.ClaimService;
import com.example.insurance.utils.ApiResponse;
import com.example.insurance.utils.Constants;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClaimServiceImpl implements ClaimService {
    private final ClaimRepository claimRepository;
    private final ClaimMapper claimMapper;

    @Override
    public ClaimResponse addClaim(AddClaimRequest request) {
        return claimMapper.toClaimResponseDTO(claimRepository.save(claimMapper.toClaim(request)));
    }

    @Override
    public ApiResponse updateClaimStatus(@NonNull Integer claimId, @NonNull Integer status) {
        claimRepository.updateClaimStatus(claimId, status);
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE);
    }


    @Override
    public ApiResponse deleteClaim(@NonNull Integer claimId) {
        claimRepository.deleteByClaimId(claimId);
        return new ApiResponse(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE);
    }


    @Override
    public List<ClaimResponse> getAllClaims(Integer customerId) {
        return claimMapper.toClaimResponseDTOList(Optional.of(claimRepository.findAllByCustomerId(customerId))
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new ClaimsNotFoundException("Claims not found")));
    }
}
