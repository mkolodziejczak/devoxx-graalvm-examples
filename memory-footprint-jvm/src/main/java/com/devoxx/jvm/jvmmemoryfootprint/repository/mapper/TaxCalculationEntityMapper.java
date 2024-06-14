package com.devoxx.jvm.jvmmemoryfootprint.repository.mapper;

import com.devoxx.jvm.jvmmemoryfootprint.model.TaxCalculationResult;
import com.devoxx.jvm.jvmmemoryfootprint.repository.entity.TaxCalculationResultEntity;

import java.time.Instant;

public enum TaxCalculationEntityMapper {
  INSTANCE;

  public TaxCalculationResultEntity toEntity(TaxCalculationResult result, String accountNumber) {
    return new TaxCalculationResultEntity(
        null,
        accountNumber,
        result.getTaxAmount(),
        result.getTaxRate(),
        result.getTaxableIncome(),
        result.getTotalExpenses(),
        Instant.now());
  }
}
