package com.devoxx.graalvm.graalvmcontainersizeexample.controller.mapper;

import com.devoxx.graalvm.graalvmcontainersizeexample.controller.dto.CreditScoreCalculationRequestDto;
import com.devoxx.graalvm.graalvmcontainersizeexample.model.Person;

public enum PersonMapper {

    INSTANCE;

    public Person mapDtoToModel(CreditScoreCalculationRequestDto creditScoreCalculationRequestDto) {
        return new Person(creditScoreCalculationRequestDto.getFirstName(), creditScoreCalculationRequestDto.getLastName(), creditScoreCalculationRequestDto.getIncomeLevel());
    }
}
