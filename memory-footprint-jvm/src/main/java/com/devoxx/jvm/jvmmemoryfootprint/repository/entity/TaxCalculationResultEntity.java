package com.devoxx.jvm.jvmmemoryfootprint.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
@Entity
@Table(name = "tax_calculation_result")
public class TaxCalculationResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "tax_amount")
    private double taxAmount;

    @Column(name = "tax_rate")
    private double taxRate;

    @Column(name = "taxable_income")
    private double taxableIncome;

    @Column(name = "total_expenses")
    private double totalExpenses;

    @Column(name = "date")
    private Instant date;

}
