package com.devoxx.jvm.jvmcontainersizeexample.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditScoreCalculationRequestDto {

    @JsonProperty("credit_history_length")
    private int creditHistoryLength;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("income_level")
    private double incomeLevel;

}
