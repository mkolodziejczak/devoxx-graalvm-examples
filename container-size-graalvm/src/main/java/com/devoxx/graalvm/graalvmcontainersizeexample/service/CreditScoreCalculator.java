package com.devoxx.graalvm.graalvmcontainersizeexample.service;

import com.devoxx.graalvm.graalvmcontainersizeexample.model.CreditScoreResult;
import com.devoxx.graalvm.graalvmcontainersizeexample.model.CreditScoreRiskLevel;
import com.devoxx.graalvm.graalvmcontainersizeexample.model.Person;
import com.devoxx.graalvm.graalvmcontainersizeexample.model.RecommendationAction;
import com.devoxx.graalvm.graalvmcontainersizeexample.repository.CreditScoreCalculationRepository;
import com.devoxx.graalvm.graalvmcontainersizeexample.repository.mapper.CreditScoreEntityMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CreditScoreCalculator {

    private final CreditScoreCalculationRepository creditScoreCalculationRepository;
    private final CreditScoreEntityMapper creditScoreEntityMapper = CreditScoreEntityMapper.INSTANCE;

    public CreditScoreCalculator(CreditScoreCalculationRepository creditScoreCalculationRepository) {
        this.creditScoreCalculationRepository = creditScoreCalculationRepository;
    }

    public CreditScoreResult calculate(Person person, int creditHistoryLength) {
        var pastScore = creditScoreCalculationRepository.findLatestByFirstNameAndLastName(person.firstName(), person.lastName());
        var now = Instant.now();
        var cutOffDate = now.minusSeconds(15768000);

        if(pastScore.isPresent() && pastScore.get().getTimestamp().isAfter(cutOffDate)) {
            var action = RecommendationAction.valueOf(pastScore.get().getRecommendation().name());
            var riskLevel = CreditScoreRiskLevel.valueOf(pastScore.get().getRiskLevel().name());
            return new CreditScoreResult(person.firstName(), person.lastName(), person.incomeLevel(), pastScore.get().getCreditScore(), riskLevel, action);
        }

        var newScore = calculateNewScore(person, creditHistoryLength);
        saveScore(newScore, creditHistoryLength);
        return newScore;
    }

    private CreditScoreResult calculateNewScore(Person person, int creditHistoryLength) {
        var creditScore = (int) (person.incomeLevel() * 0.1 + creditHistoryLength * 0.9);

        if(creditScore > 800) {
            return new CreditScoreResult(person.firstName(), person.lastName(), person.incomeLevel(), creditScore, CreditScoreRiskLevel.LOW, RecommendationAction.PROCESS);
        } else if(creditScore > 600) {
            return new CreditScoreResult(person.firstName(), person.lastName(), person.incomeLevel(), creditScore, CreditScoreRiskLevel.MEDIUM, RecommendationAction.PROCESS);
        } else {
            return new CreditScoreResult(person.firstName(), person.lastName(), person.incomeLevel(), creditScore, CreditScoreRiskLevel.HIGH, RecommendationAction.HOLD);
        }
    }

    private void saveScore(CreditScoreResult creditScoreResult, int creditHistoryLength) {
        var creditScoreEntity = creditScoreEntityMapper.map(creditScoreResult, creditHistoryLength);
        creditScoreCalculationRepository.save(creditScoreEntity);
    }

}
