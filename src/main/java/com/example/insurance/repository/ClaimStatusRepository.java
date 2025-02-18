package com.example.insurance.repository;

import com.example.insurance.entity.ClaimStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimStatusRepository extends JpaRepository<ClaimStatus, Integer> {
}
