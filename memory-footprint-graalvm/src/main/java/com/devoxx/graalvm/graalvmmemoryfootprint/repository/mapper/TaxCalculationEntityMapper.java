package com.devoxx.graalvm.graalvmmemoryfootprint.repository.mapper;

import com.devoxx.graalvm.graalvmmemoryfootprint.repository.entity.TaxCalculationResultEntity;
import com.devoxx.graalvm.graalvmmemoryfootprint.model.TaxCalculationResult;

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
