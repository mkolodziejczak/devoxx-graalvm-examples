package com.devoxx.jvm.jvmcontainersizeexample.controller.mapper;

import com.devoxx.jvm.jvmcontainersizeexample.controller.dto.Action;
import com.devoxx.jvm.jvmcontainersizeexample.controller.dto.CreditScoreCalculationResponseDto;
import com.devoxx.jvm.jvmcontainersizeexample.controller.dto.RiskLevel;
import com.devoxx.jvm.jvmcontainersizeexample.model.CreditScoreResult;

public enum CreditScoreResultMapper {
    INSTANCE;

    public CreditScoreCalculationResponseDto mapModelToDto(CreditScoreResult creditScoreResult) {
        var action = Action.valueOf(creditScoreResult.recommendation().name());
        var riskLevel = RiskLevel.valueOf(creditScoreResult.riskLevel().name());
        return new CreditScoreCalculationResponseDto(creditScoreResult.creditScore(), riskLevel, action);
    }
}
