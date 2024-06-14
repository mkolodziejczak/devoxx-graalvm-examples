package com.devoxx.jvm.jvmcoldstartexample.model;

import java.time.Instant;


public record Quotation(String symbol, String name, double price, double change, double changePercent, double volume,
                        double avgVolume, double marketCap, Instant timestamp) {
}
