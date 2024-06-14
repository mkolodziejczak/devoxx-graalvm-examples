package com.devoxx.jvm.jvmcoldstartexample.controller;

import com.devoxx.jvm.jvmcoldstartexample.controller.dto.QuotationRequestDto;
import com.devoxx.jvm.jvmcoldstartexample.controller.mapper.QuotationMapper;
import com.devoxx.jvm.jvmcoldstartexample.service.ComplexAlgorithmService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotation")
public class QuotationController {

    private final QuotationMapper quotationMapper = QuotationMapper.INSTANCE;
    private final ComplexAlgorithmService complexAlgorithmService;

    public QuotationController(ComplexAlgorithmService complexAlgorithmService) {
        this.complexAlgorithmService = complexAlgorithmService;
    }

    @PostMapping
    public void addQuotations(@RequestBody QuotationRequestDto quotationRequestDto) {
        var quotations = quotationMapper.mapDtoToModel(quotationRequestDto);
        complexAlgorithmService.processQuotationData(quotations);
    }

}
