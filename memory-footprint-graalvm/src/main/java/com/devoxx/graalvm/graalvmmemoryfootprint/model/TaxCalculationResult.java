package com.devoxx.graalvm.graalvmmemoryfootprint.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TaxCalculationResult {

    private double taxAmount;
    private double taxRate;
    private double taxableIncome;
    private double totalExpenses;

}