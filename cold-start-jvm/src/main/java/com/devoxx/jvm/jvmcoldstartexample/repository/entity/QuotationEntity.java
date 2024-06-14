package com.devoxx.jvm.jvmcoldstartexample.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(name = "quotations")
public class QuotationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "change")
    private double change;

    @Column(name = "percent_change")
    private double changePercent;

    @Column(name = "volume")
    private double volume;

    @Column(name = "average_volume")
    private double avgVolume;

    @Column(name = "market_cap")
    private double marketCap;

    @Column(name = "time_stamp")
    private Instant timestamp;
}
