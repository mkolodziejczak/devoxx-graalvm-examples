package com.devoxx.graalvm.graalvmcoldstartexample.model;

public record Recommendation(String symbol, RecommendationAction action, double confidence) {
}
