package com.example.insurance.service.serviceImpl;

import com.example.insurance.dto.AddClaimRequestDTO;
import com.example.insurance.dto.ClaimResponseDTO;
import com.example.insurance.entity.Claim;
import com.example.insurance.repository.ClaimRepository;
import com.example.insurance.utils.ApiResponse;
import com.example.insurance.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClaimServiceImplTest {

    @InjectMocks
    private ClaimServiceImpl claimService;

    @Mock
    private ClaimRepository claimRepository;

    private Claim claim;
    private AddClaimRequestDTO requestDTO;

    @BeforeEach
    void setUp() {
        claim = new Claim();
        claim.setClaimId(1);
        claim.setCustomerId(100);
        claim.setClaimAmount(new BigDecimal("5000"));
        claim.setClaimDate(new Date());
        claim.setClaimStatus(1);
        claim.setClaimType(2);
        requestDTO = new AddClaimRequestDTO();
        requestDTO.setCustomerId(100);
        requestDTO.setClaimAmount(new BigDecimal("5000"));
        requestDTO.setClaimStatus(1);
        requestDTO.setClaimType(2);
    }

    @Test
    void testAddClaim() {
        when(claimRepository.save(any(Claim.class))).thenReturn(claim);
        ApiResponse response = claimService.addClaim(requestDTO);
        assertEquals(Constants.SUCCESS_CODE, response.getStatus());
        assertEquals(Constants.SUCCESS_MESSAGE, response.getMessage());
        verify(claimRepository, times(1)).save(any(Claim.class));
    }

    @Test
    void testUpdateClaimStatus() {
        doNothing().when(claimRepository).updateClaimStatus(1, 2);
        ApiResponse response = claimService.updateClaimStatus(1, 2);
        assertEquals(Constants.SUCCESS_CODE, response.getStatus());
        assertEquals(Constants.SUCCESS_MESSAGE, response.getMessage());
        verify(claimRepository, times(1)).updateClaimStatus(1, 2);
    }

    @Test
    void testDeleteClaim() {
        doNothing().when(claimRepository).deleteByClaimId(1);
        ApiResponse response = claimService.deleteClaim(1);
        assertEquals(Constants.SUCCESS_CODE, response.getStatus());
        assertEquals(Constants.SUCCESS_MESSAGE, response.getMessage());
        verify(claimRepository, times(1)).deleteByClaimId(1);
    }

    @Test
    void testGetAllClaims() throws Exception {
        when(claimRepository.findAllByCustomerId(100)).thenReturn(Collections.singletonList(claim));
        ApiResponse response = claimService.getAllClaims(100);
        List<ClaimResponseDTO> responseDTOs = (List<ClaimResponseDTO>) response.getData();
        assertEquals(Constants.SUCCESS_CODE, response.getStatus());
        assertEquals(1, responseDTOs.size());
        verify(claimRepository, times(1)).findAllByCustomerId(100);
    }
}
