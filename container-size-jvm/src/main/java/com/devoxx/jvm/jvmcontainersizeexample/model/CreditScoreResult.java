package com.devoxx.jvm.jvmcontainersizeexample.model;

public record CreditScoreResult(
    String firstName,
    String lastName,
    double incomeLevel,
    int creditScore,
    CreditScoreRiskLevel riskLevel,
    RecommendationAction recommendation) {}
