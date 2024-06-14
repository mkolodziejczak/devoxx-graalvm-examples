package com.devoxx.graalvm.graalvmcoldstartexample.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuotationRequestDto {

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private double price;

    @JsonProperty("change")
    private double change;

    @JsonProperty("change_percent")
    private double changePercent;

    @JsonProperty("volume")
    private double volume;

    @JsonProperty("avg_volume")
    private double avgVolume;

    @JsonProperty("market_cap")
    private double marketCap;

    @JsonProperty("timestamp")
    private Instant timestamp;
}
