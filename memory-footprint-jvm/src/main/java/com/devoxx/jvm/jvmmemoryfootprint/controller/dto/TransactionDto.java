package com.devoxx.jvm.jvmmemoryfootprint.controller.dto;

import com.devoxx.jvm.jvmmemoryfootprint.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

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
