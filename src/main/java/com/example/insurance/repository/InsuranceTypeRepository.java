package com.example.insurance.repository;

import com.example.insurance.entity.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, Integer> {

}
