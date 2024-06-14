package com.devoxx.graalvm.graalvmcoldstartexample.repository;

import com.devoxx.graalvm.graalvmcoldstartexample.repository.entity.QuotationEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuotationRepository extends JpaRepository<QuotationEntity, Long> {


    public Optional<QuotationEntity> findLastBySymbolOrderByTimestamp(String symbol);

    public List<QuotationEntity> findLatestBySymbol(String symbol, Pageable pageable);
}
