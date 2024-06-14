package com.devoxx.graalvm.graalvmmemoryfootprint.controller;

import com.devoxx.graalvm.graalvmmemoryfootprint.controller.dto.BankStatementDto;
import com.devoxx.graalvm.graalvmmemoryfootprint.controller.dto.TaxCalculationResponseDto;
import com.devoxx.graalvm.graalvmmemoryfootprint.controller.mapper.BankStatementMapper;
import com.devoxx.graalvm.graalvmmemoryfootprint.controller.mapper.TaxCalculationResultMapper;
import com.devoxx.graalvm.graalvmmemoryfootprint.service.TaxCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/taxCalculation")
public class TaxCalculationController {

    private final TaxCalculator taxCalculator;
    private final TaxCalculationResultMapper taxCalculationResultMapper = TaxCalculationResultMapper.INSTANCE;
    private final BankStatementMapper bankStatementMapper = BankStatementMapper.INSTANCE;

    public TaxCalculationController(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @GetMapping
    public ResponseEntity<TaxCalculationResponseDto> calculateTax(@RequestBody BankStatementDto bankStatementDto) {
        var bankStatement = bankStatementMapper.mapDtoToModel(bankStatementDto);
        var result = taxCalculator.calculateTax(bankStatement);
        return ResponseEntity.ok(taxCalculationResultMapper.toDto(result));
    }

}
