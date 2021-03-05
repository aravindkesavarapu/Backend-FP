package com.cg.csd.financialpartners.service;

import java.util.List;

import com.cg.csd.financialpartners.entity.BankAccountEntity;
import com.cg.csd.financialpartners.entity.TransactionEntity;
import com.cg.csd.financialpartners.exception.FinancialException;

public interface TransactionService {
public TransactionEntity addTransction(TransactionEntity transactionEntity) throws FinancialException;
public List<TransactionEntity> getAllTransaction(Long customerId);
public List<TransactionEntity> getMiniStatement(Long customerId);
public TransactionEntity transfer(TransactionEntity transactionEntity);

}
