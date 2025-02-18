package com.example.insurance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.BitSet;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "claim")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLAIM_ID", nullable = false)
    private Integer claimId;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Integer customerId;

    @Column(name = "CLAIM_TYPE", nullable = false)
    private Integer claimType;

    @Column(name = "CLAIM_DATE", nullable = false)
    private Date claimDate;

    @Column(name = "CLAIM_STATUS", nullable = false)
    private Integer claimStatus;

    @Column(name = "CLAIM_AMOUNT", nullable = false)
    private BigDecimal claimAmount;
}
