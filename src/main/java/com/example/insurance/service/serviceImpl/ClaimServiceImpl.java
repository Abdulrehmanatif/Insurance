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

@Slf4j
@Service
@RequiredArgsConstructor
public class ClaimServiceImpl implements ClaimService {
    private final ClaimRepository claimRepository;
    private final ClaimMapper claimMapper;

    @Override
    public ApiResponse<ClaimResponse> addClaim(AddClaimRequest request) {
        log.info("Adding new claim: {}", request);
        var response = claimMapper.toClaimResponseDTO(claimRepository.save(claimMapper.toClaim(request)));
        log.info("Claim added successfully");
        return new ApiResponse<>(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, response);
    }

    @Override
    public ApiResponse<ClaimResponse> updateClaimStatus(@NonNull Integer claimId, @NonNull Integer status) {
        log.info("Updating claim status for claimId: {} to status: {}", claimId, status);
        ClaimResponse response = claimMapper.toClaimResponseDTO(claimRepository.updateClaimStatus(claimId, status));
        log.info("Claim status updated successfully for claimId: {}", claimId);
        return new ApiResponse<>(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, response);
    }

    @Override
    public ApiResponse<?> deleteClaim(@NonNull Integer claimId) {
        log.info("Deleting claim with ID: {}", claimId);
        claimRepository.deleteByClaimId(claimId);
        log.info("Claim deleted successfully with ID: {}", claimId);
        return new ApiResponse<>(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE);
    }

    @Override
    public ApiResponse<List<ClaimResponse>> getAllClaims(Integer customerId) {
        log.info("Fetching all claims for customerId: {}", customerId);
        var claims = claimRepository.findAllByCustomerId(customerId);
        if (claims.isEmpty()) {
            log.warn("No claims found for customerId: {}", customerId);
            throw new ClaimsNotFoundException("Claims not found");
        }
        log.info("Retrieved {} claims for customerId: {}", claims.size(), customerId);
        return new ApiResponse<>(Constants.SUCCESS_CODE, Constants.SUCCESS_MESSAGE, claimMapper.toClaimResponseDTOList(claims));
    }
}
