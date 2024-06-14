package com.devoxx.graalvm.graalvmcoldstartexample.controller.mapper;

import com.devoxx.graalvm.graalvmcoldstartexample.controller.dto.Action;
import com.devoxx.graalvm.graalvmcoldstartexample.controller.dto.RecommendationResponseDto;
import com.devoxx.graalvm.graalvmcoldstartexample.model.Recommendation;

public enum RecommendationMapper {

    INSTANCE;

    public RecommendationResponseDto toDto(Recommendation recommendation) {
        var action = Action.valueOf(recommendation.action().name());
        return new RecommendationResponseDto(recommendation.symbol(),  action, recommendation.confidence());
    }
}
