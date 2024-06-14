package com.devoxx.jvm.jvmcoldstartexample.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendationResponseDto {

    private String symbol;
    private Action action;
    private double confidence;

}
