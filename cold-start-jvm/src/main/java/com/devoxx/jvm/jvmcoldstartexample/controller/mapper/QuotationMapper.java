package com.devoxx.jvm.jvmcoldstartexample.controller.mapper;

import com.devoxx.jvm.jvmcoldstartexample.controller.dto.QuotationRequestDto;
import com.devoxx.jvm.jvmcoldstartexample.model.Quotation;

public enum QuotationMapper {

    INSTANCE;

    public Quotation mapDtoToModel(QuotationRequestDto quotationRequestDto) {
        return new Quotation(quotationRequestDto.getSymbol(), quotationRequestDto.getName(), quotationRequestDto.getPrice(), quotationRequestDto.getChange(), quotationRequestDto.getChangePercent(), quotationRequestDto.getVolume(), quotationRequestDto.getAvgVolume(), quotationRequestDto.getMarketCap(), quotationRequestDto.getTimestamp());
    }
}
