package com.devoxx.jvm.jvmcoldstartexample.repository.mapper;

import com.devoxx.jvm.jvmcoldstartexample.model.Recommendation;
import com.devoxx.jvm.jvmcoldstartexample.model.RecommendationAction;
import com.devoxx.jvm.jvmcoldstartexample.repository.entity.RecommendationEntity;

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
