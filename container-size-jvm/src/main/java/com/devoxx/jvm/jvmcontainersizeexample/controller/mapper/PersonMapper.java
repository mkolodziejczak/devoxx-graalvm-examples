package com.devoxx.jvm.jvmcontainersizeexample.controller.mapper;

import com.devoxx.jvm.jvmcontainersizeexample.controller.dto.CreditScoreCalculationRequestDto;
import com.devoxx.jvm.jvmcontainersizeexample.model.Person;

public enum PersonMapper {

    INSTANCE;

    public Person mapDtoToModel(CreditScoreCalculationRequestDto creditScoreCalculationRequestDto) {
        return new Person(creditScoreCalculationRequestDto.getFirstName(), creditScoreCalculationRequestDto.getLastName(), creditScoreCalculationRequestDto.getIncomeLevel());
    }
}
