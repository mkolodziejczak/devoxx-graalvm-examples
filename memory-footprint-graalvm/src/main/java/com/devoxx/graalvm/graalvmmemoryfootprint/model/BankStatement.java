package com.devoxx.graalvm.graalvmmemoryfootprint.model;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BankStatement {

    private String accountNumber;
    private Instant startDate;
    private Instant endDate;
    private List<Transaction> transactions;
    private double startingBalance;
    private double endingBalance;

}