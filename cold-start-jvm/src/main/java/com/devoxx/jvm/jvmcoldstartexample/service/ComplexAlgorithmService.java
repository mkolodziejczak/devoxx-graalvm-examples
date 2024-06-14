package com.devoxx.jvm.jvmcoldstartexample.service;

import com.devoxx.jvm.jvmcoldstartexample.model.Quotation;
import com.devoxx.jvm.jvmcoldstartexample.model.Recommendation;
import com.devoxx.jvm.jvmcoldstartexample.model.RecommendationAction;
import com.devoxx.jvm.jvmcoldstartexample.repository.QuotationRepository;
import com.devoxx.jvm.jvmcoldstartexample.repository.RecommendationRepository;
import com.devoxx.jvm.jvmcoldstartexample.repository.mapper.QuotationEntityMapper;
import com.devoxx.jvm.jvmcoldstartexample.repository.mapper.RecommendationEntityMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ComplexAlgorithmService {

    private final QuotationRepository quotationRepository;
    private final RecommendationRepository recommendationRepository;

    private final RecommendationEntityMapper mapper = RecommendationEntityMapper.INSTANCE;
    private final QuotationEntityMapper quotationEntityMapper = QuotationEntityMapper.INSTANCE;

    public ComplexAlgorithmService(QuotationRepository quotationRepository, RecommendationRepository recommendationRepository) {
        this.quotationRepository = quotationRepository;
        this.recommendationRepository = recommendationRepository;
    }

    public void processQuotationData(Quotation quotation) {
        var quotationEntity = quotationEntityMapper.map(quotation);
        quotationRepository.save(quotationEntity);
        signalGenerationAlgorithm(quotation);

    }

    public Recommendation issueRecommendation(String stockSymbol) {

        var latestRecommendation = recommendationRepository.findLastByStockSymbolOrderByStockSymbol(stockSymbol);
        var latestQuotation = quotationRepository.findLastBySymbolOrderByTimestamp(stockSymbol);

        if (latestRecommendation.isPresent() && latestQuotation.isPresent() && latestQuotation.get().getTimestamp().equals(latestRecommendation.get().getQuotationTimestamp())) {
            return mapper.mapEntityToModel(latestRecommendation.get());
        }

        return complexAssessmentAlgorithm(stockSymbol, 10);
    }

    private void signalGenerationAlgorithm(Quotation quotation) {
        var recommendation = complexAssessmentAlgorithm(quotation.symbol(), 10);

        if(recommendation.confidence() == 1.0) {
            //INTEGRATE WITH SERVICE ACCEPTING TRADING SIGNALS
        }
    }

    private Recommendation complexAssessmentAlgorithm(String stockSymbol, int numOfRecords) {

        var latestQuotations = quotationRepository.findLatestBySymbol(stockSymbol, PageRequest.of(0, numOfRecords));

        var positive = 0;
        var negative = 0;

        for(var quotation : latestQuotations) {
            if (quotation.getChange() > 0) {
                positive++;
            } else {
                negative++;
            }
        }

        if(positive > negative) {
            return new Recommendation(stockSymbol, RecommendationAction.BUY, (double) positive / numOfRecords);
        } else {
            return new Recommendation(stockSymbol, RecommendationAction.SELL, (double) negative / numOfRecords);
        }
    }
}
