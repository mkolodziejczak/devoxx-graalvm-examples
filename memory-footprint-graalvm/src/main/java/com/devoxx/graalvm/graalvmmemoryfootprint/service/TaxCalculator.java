package com.devoxx.graalvm.graalvmmemoryfootprint.service;

import com.devoxx.graalvm.graalvmmemoryfootprint.model.TransactionType;
import com.devoxx.graalvm.graalvmmemoryfootprint.repository.TaxCalculationResultRepository;
import com.devoxx.graalvm.graalvmmemoryfootprint.repository.mapper.TaxCalculationEntityMapper;
import com.devoxx.graalvm.graalvmmemoryfootprint.model.BankStatement;
import com.devoxx.graalvm.graalvmmemoryfootprint.model.TaxCalculationResult;
import com.devoxx.graalvm.graalvmmemoryfootprint.model.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
