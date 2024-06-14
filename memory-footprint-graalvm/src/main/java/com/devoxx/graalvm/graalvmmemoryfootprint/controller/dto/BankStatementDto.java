package com.devoxx.graalvm.graalvmmemoryfootprint.controller.dto;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
