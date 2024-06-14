package com.devoxx.graalvm.graalvmcontainersizeexample.controller;

import com.devoxx.graalvm.graalvmcontainersizeexample.controller.dto.CreditScoreCalculationRequestDto;
import com.devoxx.graalvm.graalvmcontainersizeexample.controller.dto.CreditScoreCalculationResponseDto;
import com.devoxx.graalvm.graalvmcontainersizeexample.controller.mapper.CreditScoreResultMapper;
import com.devoxx.graalvm.graalvmcontainersizeexample.controller.mapper.PersonMapper;
import com.devoxx.graalvm.graalvmcontainersizeexample.service.CreditScoreCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotation")
public class CreditScoreCalculationController {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private final CreditScoreResultMapper resultMapper = CreditScoreResultMapper.INSTANCE;
    private final CreditScoreCalculator creditScoreCalculator;

    public CreditScoreCalculationController(CreditScoreCalculator creditScoreCalculator) {
        this.creditScoreCalculator = creditScoreCalculator;
    }

    @PostMapping
    public ResponseEntity<CreditScoreCalculationResponseDto> addQuotations(@RequestBody CreditScoreCalculationRequestDto creditScoreCalculationRequestDto) {
        var person = personMapper.mapDtoToModel(creditScoreCalculationRequestDto);
        var score = creditScoreCalculator.calculate(person, creditScoreCalculationRequestDto.getCreditHistoryLength());
        var dto = resultMapper.mapModelToDto(score);
        return ResponseEntity.ok(dto);
    }

}
