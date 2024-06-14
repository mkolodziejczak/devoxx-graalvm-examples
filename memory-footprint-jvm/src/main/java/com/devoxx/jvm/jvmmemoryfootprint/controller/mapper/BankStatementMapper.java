package com.devoxx.jvm.jvmmemoryfootprint.controller.mapper;

import com.devoxx.jvm.jvmmemoryfootprint.controller.dto.BankStatementDto;
import com.devoxx.jvm.jvmmemoryfootprint.controller.dto.TransactionDto;
import com.devoxx.jvm.jvmmemoryfootprint.model.BankStatement;
import com.devoxx.jvm.jvmmemoryfootprint.model.Transaction;
import com.devoxx.jvm.jvmmemoryfootprint.model.TransactionType;

public enum BankStatementMapper {

    INSTANCE;


    public BankStatement mapDtoToModel(BankStatementDto bankStatementDto) {
        var transactions = bankStatementDto.getTransactions().stream().map(this::mapTransactionDtoToModel).toList();
        return new BankStatement(bankStatementDto.getAccountNumber(), bankStatementDto.getStartDate(), bankStatementDto.getEndDate(), transactions, bankStatementDto.getStartingBalance(), bankStatementDto.getEndingBalance());
    }

    private Transaction mapTransactionDtoToModel(TransactionDto transactionDto) {
        return new Transaction(transactionDto.getDate(), transactionDto.getDescription(), transactionDto.getAmount(), TransactionType.valueOf(transactionDto.getType()));
    }
}
