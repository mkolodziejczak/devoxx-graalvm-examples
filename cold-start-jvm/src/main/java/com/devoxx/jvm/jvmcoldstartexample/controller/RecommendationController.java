package com.devoxx.jvm.jvmcoldstartexample.controller;

import com.devoxx.jvm.jvmcoldstartexample.controller.dto.RecommendationResponseDto;
import com.devoxx.jvm.jvmcoldstartexample.controller.mapper.RecommendationMapper;
import com.devoxx.jvm.jvmcoldstartexample.service.ComplexAlgorithmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    private final ComplexAlgorithmService complexAlgorithmService;
    private final RecommendationMapper recommendationMapper = RecommendationMapper.INSTANCE;

    public RecommendationController(ComplexAlgorithmService complexAlgorithmService) {
        this.complexAlgorithmService = complexAlgorithmService;
    }

    @GetMapping
    public ResponseEntity<RecommendationResponseDto> getRecommendation(@RequestParam String stockSymbol) {
        var recommendation = complexAlgorithmService.issueRecommendation(stockSymbol);
        return ResponseEntity.ok(recommendationMapper.toDto(recommendation));
    }

}
