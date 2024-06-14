package com.devoxx.graalvm.graalvmmemoryfootprint.controller.dto;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionDto {

    private Instant date;
    private String description;
    private double amount;
    private String type;

}
