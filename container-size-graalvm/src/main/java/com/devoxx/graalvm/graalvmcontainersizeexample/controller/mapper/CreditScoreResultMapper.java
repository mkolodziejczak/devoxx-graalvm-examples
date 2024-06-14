package com.devoxx.graalvm.graalvmcontainersizeexample.controller.mapper;

import com.devoxx.graalvm.graalvmcontainersizeexample.controller.dto.CreditScoreCalculationResponseDto;
import com.devoxx.graalvm.graalvmcontainersizeexample.controller.dto.RiskLevel;
import com.devoxx.graalvm.graalvmcontainersizeexample.controller.dto.Action;
import com.devoxx.graalvm.graalvmcontainersizeexample.model.CreditScoreResult;

public enum CreditScoreResultMapper {
    INSTANCE;

    public CreditScoreCalculationResponseDto mapModelToDto(CreditScoreResult creditScoreResult) {
        var action = Action.valueOf(creditScoreResult.recommendation().name());
        var riskLevel = RiskLevel.valueOf(creditScoreResult.riskLevel().name());
        return new CreditScoreCalculationResponseDto(creditScoreResult.creditScore(), riskLevel, action);
    }
}
