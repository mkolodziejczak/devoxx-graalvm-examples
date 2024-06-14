package com.devoxx.jvm.jvmmemoryfootprint.model;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Transaction {
    private Instant date;
    private String description;
    private double amount;
    private TransactionType type;

}