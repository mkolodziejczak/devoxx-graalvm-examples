package com.devoxx.graalvm.graalvmcoldstartexample.repository.mapper;

import com.devoxx.graalvm.graalvmcoldstartexample.model.Recommendation;
import com.devoxx.graalvm.graalvmcoldstartexample.model.RecommendationAction;
import com.devoxx.graalvm.graalvmcoldstartexample.repository.entity.RecommendationEntity;

public enum RecommendationEntityMapper {
    INSTANCE;

    public Recommendation mapEntityToModel(RecommendationEntity recommendationEntity) {

        RecommendationAction action = RecommendationAction.valueOf(recommendationEntity.getEntityAction().toString());

        return new Recommendation(
                recommendationEntity.getStockSymbol(),
                action,
                recommendationEntity.getConfidence()
        );
    }
}
