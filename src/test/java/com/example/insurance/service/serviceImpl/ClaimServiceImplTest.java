//package com.example.insurance.service.serviceImpl;
//
//import com.example.insurance.dto.AddClaimRequest;
//import com.example.insurance.dto.ClaimResponse;
//import com.example.insurance.entity.Claim;
//import com.example.insurance.exception.ClaimsNotFoundException;
//import com.example.insurance.mapper.ClaimMapper;
//import com.example.insurance.repository.ClaimRepository;
//import com.example.insurance.service.serviceImpl.ClaimServiceImpl;
//import com.example.insurance.utils.ApiResponse;
//import com.example.insurance.utils.Constants;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class ClaimServiceImplTest {
//
//    @Mock
//    private ClaimRepository claimRepository;
//
//    @Mock
//    private ClaimMapper claimMapper;
//
//    @InjectMocks
//    private ClaimServiceImpl claimService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testAddClaim() {
//        Claim claim = claimRepository.save(new Claim(1, 1, 1, new Date(), 1, BigDecimal.valueOf(10000)));
//        ClaimResponse response = claimMapper.toClaimResponseDTO(claim);
//        verify(claimRepository, times(1)).save(any(Claim.class));
//        verify(claimMapper, times(1)).toClaimResponseDTO(any(Claim.class));
//    }
//
//    @Test
//    void testUpdateClaimStatus() {
//        Integer claimId = 1;
//        Integer status = 2;
//        doNothing().when(claimRepository).updateClaimStatus(claimId, status);
//        claimRepository.updateClaimStatus(claimId, status);
//        verify(claimRepository, times(1)).updateClaimStatus(claimId, status);
//    }
//
//    @Test
//    void testDeleteClaim() {
//        Integer claimId = 1;
//        doNothing().when(claimRepository).deleteByClaimId(claimId);
//        claimRepository.deleteByClaimId(claimId);
//        verify(claimRepository, times(1)).deleteByClaimId(claimId);
//    }
//
//    @Test
//    void testGetAllClaims_Success() {
//        Integer customerId = 1;
//        List<Claim> claims = claimRepository.findAllByCustomerId(customerId);
//        List<ClaimResponse> result = claimService.getAllClaims(customerId);
//        when(claimRepository.findAllByCustomerId(customerId)).thenReturn(claims);
//        when(claimMapper.toClaimResponseDTOList(claims)).thenReturn(result);
//        assertNotNull(result);
//        assertEquals(1, result.size());
//        verify(claimRepository, times(1)).findAllByCustomerId(customerId);
//        verify(claimMapper, times(1)).toClaimResponseDTOList(claims);
//    }
//}
