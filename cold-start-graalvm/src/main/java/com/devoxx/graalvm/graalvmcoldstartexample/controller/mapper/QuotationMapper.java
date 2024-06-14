package com.devoxx.graalvm.graalvmcoldstartexample.controller.mapper;

import com.devoxx.graalvm.graalvmcoldstartexample.model.Quotation;
import com.devoxx.graalvm.graalvmcoldstartexample.controller.dto.QuotationRequestDto;

public enum QuotationMapper {

    INSTANCE;

    public Quotation mapDtoToModel(QuotationRequestDto quotationRequestDto) {
        return new Quotation(quotationRequestDto.getSymbol(), quotationRequestDto.getName(), quotationRequestDto.getPrice(), quotationRequestDto.getChange(), quotationRequestDto.getChangePercent(), quotationRequestDto.getVolume(), quotationRequestDto.getAvgVolume(), quotationRequestDto.getMarketCap(), quotationRequestDto.getTimestamp());
    }
}
