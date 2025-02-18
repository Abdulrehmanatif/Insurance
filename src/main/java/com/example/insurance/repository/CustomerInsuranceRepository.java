package com.example.insurance.repository;

import com.example.insurance.entity.CustomerInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInsuranceRepository extends JpaRepository<CustomerInsurance, Integer> {
}
