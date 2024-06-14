package com.devoxx.jvm.jvmcontainersizeexample.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreditScoreCalculationResponseDto {

    private int creditScore;
    private RiskLevel riskLevel;
    private Action recommendation;

}
