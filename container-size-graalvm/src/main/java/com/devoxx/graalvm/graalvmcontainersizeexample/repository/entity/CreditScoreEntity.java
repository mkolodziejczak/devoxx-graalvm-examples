package com.devoxx.graalvm.graalvmcontainersizeexample.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@Table(name = "credit_score_calculation")
@AllArgsConstructor
@NoArgsConstructor
public class CreditScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "income_level")
    private double incomeLevel;

    @Column(name = "credit_history_length")
    private int creditHistoryLength;

    @Column(name = "credit_score")
    private int creditScore;

    @Column(name = "risk_level")
    private EntityRiskLevel riskLevel;

    @Column(name = "recommendation")
    private EntityAction recommendation;

    @Column(name = "time_stamp")
    private Instant timestamp;
}
