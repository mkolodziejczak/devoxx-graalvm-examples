package com.devoxx.graalvm.graalvmmemoryfootprint.controller.mapper;

import com.devoxx.graalvm.graalvmmemoryfootprint.controller.dto.TaxCalculationResponseDto;
import com.devoxx.graalvm.graalvmmemoryfootprint.model.TaxCalculationResult;

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
