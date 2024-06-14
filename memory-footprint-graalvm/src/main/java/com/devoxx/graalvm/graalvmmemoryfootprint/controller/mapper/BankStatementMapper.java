package com.devoxx.graalvm.graalvmmemoryfootprint.controller.mapper;

import com.devoxx.graalvm.graalvmmemoryfootprint.controller.dto.BankStatementDto;
import com.devoxx.graalvm.graalvmmemoryfootprint.controller.dto.TransactionDto;
import com.devoxx.graalvm.graalvmmemoryfootprint.model.BankStatement;
import com.devoxx.graalvm.graalvmmemoryfootprint.model.Transaction;
import com.devoxx.graalvm.graalvmmemoryfootprint.model.TransactionType;

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
