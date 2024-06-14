package com.devoxx.jvm.jvmmemoryfootprint.service;

import com.devoxx.jvm.jvmmemoryfootprint.model.BankStatement;
import com.devoxx.jvm.jvmmemoryfootprint.model.TaxCalculationResult;
import com.devoxx.jvm.jvmmemoryfootprint.model.Transaction;
import com.devoxx.jvm.jvmmemoryfootprint.model.TransactionType;
import com.devoxx.jvm.jvmmemoryfootprint.repository.TaxCalculationResultRepository;
import com.devoxx.jvm.jvmmemoryfootprint.repository.mapper.TaxCalculationEntityMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.IntStream.range;

@Service
public class TaxCalculator {

    private final TaxCalculationResultRepository taxCalculationResultRepository;

    private final TaxCalculationEntityMapper mapper = TaxCalculationEntityMapper.INSTANCE;

    public TaxCalculator(TaxCalculationResultRepository taxCalculationResultRepository) {
        this.taxCalculationResultRepository = taxCalculationResultRepository;
    }

    public TaxCalculationResult calculateTax(BankStatement bankStatement) {


        var taxableIncome = 0.0;
        var totalExpenses = 0.0;
        var taxAmount = 0.0;
        var taxRate = 0.0;

        for(var transaction : bankStatement.getTransactions()) {
            if(transaction.getType() == TransactionType.INCOMING) {
                taxableIncome += transaction.getAmount();
            } else {
                totalExpenses += transaction.getAmount();
            }
        }

        if(taxableIncome > 85000) {
            taxRate = 0.3;
        } else {
            taxRate = 0.18;
        }

        if(taxableIncome > 0) {
            taxAmount = taxableIncome * taxRate;
        }

        var taxCalculationResult = new TaxCalculationResult(taxAmount, taxRate, taxableIncome, totalExpenses);
        taxCalculationResultRepository.save(mapper.toEntity(taxCalculationResult, bankStatement.getAccountNumber()));

        return taxCalculationResult;
    }
}
