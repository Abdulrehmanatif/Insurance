package com.example.insurance.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_insurance")
public class CustomerInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_INSURANCE_ID")
    private Integer customerInsuranceId;

    @Column(name = "INSURANCE_ID", nullable = false)
    private Integer insuranceId;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Integer customerId;
}
