package com.devoxx.graalvm.graalvmcontainersizeexample.repository.mapper;

import com.devoxx.graalvm.graalvmcontainersizeexample.model.CreditScoreResult;
import com.devoxx.graalvm.graalvmcontainersizeexample.repository.entity.EntityAction;
import com.devoxx.graalvm.graalvmcontainersizeexample.repository.entity.EntityRiskLevel;
import com.devoxx.graalvm.graalvmcontainersizeexample.repository.entity.CreditScoreEntity;

import java.time.Instant;

public enum CreditScoreEntityMapper {

    INSTANCE;

    public CreditScoreEntity map(CreditScoreResult creditScoreResult, int creditHistoryLength) {
        var action = EntityAction.valueOf(creditScoreResult.riskLevel().name());
        var recommendation = EntityRiskLevel.valueOf(creditScoreResult.recommendation().name());
        return new CreditScoreEntity(
                null,
                creditScoreResult.firstName(),
                creditScoreResult.lastName(),
                creditScoreResult.incomeLevel(),
                creditScoreResult.creditScore(),
                creditHistoryLength,
                recommendation,
                action,
                Instant.now()
        );
    }
}
