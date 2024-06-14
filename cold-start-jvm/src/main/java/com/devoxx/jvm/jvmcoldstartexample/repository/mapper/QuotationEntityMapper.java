package com.devoxx.jvm.jvmcoldstartexample.repository.mapper;

import com.devoxx.jvm.jvmcoldstartexample.model.Quotation;
import com.devoxx.jvm.jvmcoldstartexample.repository.entity.QuotationEntity;

public enum QuotationEntityMapper {

    INSTANCE;

    public QuotationEntity map(Quotation quotation) {
        QuotationEntity quotationEntity = new QuotationEntity();
        quotationEntity.setSymbol(quotation.symbol());
        quotationEntity.setPrice(quotation.price());
        quotationEntity.setTimestamp(quotation.timestamp());
        quotationEntity.setName(quotation.name());
        quotationEntity.setChange(quotation.change());
        quotationEntity.setChangePercent(quotation.changePercent());
        return quotationEntity;
    }
}
