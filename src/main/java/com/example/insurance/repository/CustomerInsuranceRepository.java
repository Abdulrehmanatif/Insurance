package com.example.insurance.repository;

import com.example.insurance.entity.CustomerInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerInsuranceRepository extends JpaRepository<CustomerInsurance, Integer> {

    List<CustomerInsurance> findAllByCustomerId(Integer customerId);

}
