package com.devoxx.graalvm.graalvmcoldstartexample.repository;

import com.devoxx.graalvm.graalvmcoldstartexample.repository.entity.RecommendationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationEntity, Long> {

    public Optional<RecommendationEntity> findLastByStockSymbolOrderByStockSymbol(String symbol);
}
