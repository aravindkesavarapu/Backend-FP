package com.cg.csd.financialpartners.service;

import java.util.List;

import com.cg.csd.financialpartners.entity.TransactionEntity;

public interface TransactionService {
public TransactionEntity addTransaction(TransactionEntity transactionEntity);
public List<TransactionEntity> getAllTransaction(Long customerId);
public List<TransactionEntity> getMiniStatement(Long customerId);
}
