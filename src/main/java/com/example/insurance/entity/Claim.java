package com.example.insurance.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    public Claim(Integer claimId, Integer customerId, Integer claimType, Date date, Integer claimStatus, BigDecimal bigDecimal) {
        this.claimId = claimId;
        this.customerId = customerId;
        this.claimType = claimType;
        this.claimDate = date;
        this.claimStatus = claimStatus;
        this.claimAmount = bigDecimal;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Claim claim = (Claim) o;
        return getClaimId() != null && Objects.equals(getClaimId(), claim.getClaimId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
