package com.devoxx.jvm.jvmcoldstartexample.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(name = "recommendations")
public class RecommendationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_symbol")
    private String stockSymbol;

    @Column(name = "quotation_timestamp")
    private Instant quotationTimestamp;

    @Column(name = "action")
    @Enumerated(EnumType.STRING)
    private EntityAction entityAction;

    @Column(name = "confidence")
    private double confidence;

}
