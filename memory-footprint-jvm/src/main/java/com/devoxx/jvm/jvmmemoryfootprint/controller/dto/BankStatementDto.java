package com.devoxx.jvm.jvmmemoryfootprint.controller.dto;

import com.devoxx.jvm.jvmmemoryfootprint.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankStatementDto {

    private String accountNumber;
    private Instant startDate;
    private Instant endDate;
    private List<TransactionDto> transactions;
    private double startingBalance;
    private double endingBalance;

}
