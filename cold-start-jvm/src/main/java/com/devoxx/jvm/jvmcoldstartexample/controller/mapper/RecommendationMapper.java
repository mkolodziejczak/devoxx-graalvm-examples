package com.devoxx.jvm.jvmcoldstartexample.controller.mapper;

import com.devoxx.jvm.jvmcoldstartexample.controller.dto.Action;
import com.devoxx.jvm.jvmcoldstartexample.controller.dto.RecommendationResponseDto;
import com.devoxx.jvm.jvmcoldstartexample.model.Recommendation;

public enum RecommendationMapper {

    INSTANCE;

    public RecommendationResponseDto toDto(Recommendation recommendation) {
        var action = Action.valueOf(recommendation.action().name());
        return new RecommendationResponseDto(recommendation.symbol(),  action, recommendation.confidence());
    }
}
