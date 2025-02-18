package com.example.insurance.repository;

import com.example.insurance.entity.Claim;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {

    @Transactional
    @Modifying
    void deleteByClaimId(Integer claimId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE insurance.claim SET claim_status = :status WHERE (claim_id = :claimId)", nativeQuery = true)
    void updateClaimStatus(Integer claimId, Integer status);

    List<Claim> findAllByCustomerId(Integer customerId);
}
