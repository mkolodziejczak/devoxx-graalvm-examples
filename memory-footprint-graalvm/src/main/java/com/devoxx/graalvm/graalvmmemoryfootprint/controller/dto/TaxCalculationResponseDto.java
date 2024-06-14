package com.devoxx.graalvm.graalvmmemoryfootprint.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaxCalculationResponseDto {

    private double taxAmount;
    private double taxRate;
    private double taxableIncome;
    private double totalExpenses;

}
