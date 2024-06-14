package com.devoxx.graalvm.graalvmmemoryfootprint.model;

import java.time.Instant;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Transaction {
    private Instant date;
    private String description;
    private double amount;
    private TransactionType type;

}