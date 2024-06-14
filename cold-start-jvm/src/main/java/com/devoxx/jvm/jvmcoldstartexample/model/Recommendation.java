package com.devoxx.jvm.jvmcoldstartexample.model;

public record Recommendation(String symbol, RecommendationAction action, double confidence) {
}
