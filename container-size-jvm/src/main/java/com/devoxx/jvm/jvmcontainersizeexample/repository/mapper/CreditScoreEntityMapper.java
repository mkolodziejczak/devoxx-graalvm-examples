package com.devoxx.jvm.jvmcontainersizeexample.repository.mapper;

import com.devoxx.jvm.jvmcontainersizeexample.model.CreditScoreResult;
import com.devoxx.jvm.jvmcontainersizeexample.repository.entity.CreditScoreEntity;
import com.devoxx.jvm.jvmcontainersizeexample.repository.entity.EntityAction;
import com.devoxx.jvm.jvmcontainersizeexample.repository.entity.EntityRiskLevel;

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
