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
    @Query("UPDATE Claim c SET c.claimStatus = :status WHERE c.claimId = :claimId")
    void updateClaimStatus(@Param("claimId") Integer claimId, @Param("status") Integer status);

    List<Claim> findAllByCustomerId(Integer customerId);
}
