package com.example.insurance.repository;

import com.example.insurance.entity.Claim;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {

    @Transactional
    @Modifying
    void deleteByClaimId(Integer claimId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE claim c SET c.claim_status = :status WHERE c.claim_id = :claimId RETURNING *", nativeQuery = true)
    Claim updateClaimStatus(@Param("claimId") Integer claimId, @Param("status") Integer status);


    List<Claim> findAllByCustomerId(Integer customerId);
}
