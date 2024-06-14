package com.devoxx.jvm.jvmmemoryfootprint.controller.mapper;

import com.devoxx.jvm.jvmmemoryfootprint.controller.dto.TaxCalculationResponseDto;
import com.devoxx.jvm.jvmmemoryfootprint.model.TaxCalculationResult;

public enum TaxCalculationResultMapper {
  INSTANCE;

  public TaxCalculationResponseDto toDto(TaxCalculationResult result) {
    return new TaxCalculationResponseDto(
        result.getTaxAmount(),
        result.getTaxRate(),
        result.getTaxableIncome(),
        result.getTotalExpenses());
  }
}
