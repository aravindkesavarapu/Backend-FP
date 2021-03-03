package com.cg.csd.financialpartners.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.csd.financialpartners.entity.Response;
import com.cg.csd.financialpartners.entity.TransactionEntity;
import com.cg.csd.financialpartners.exception.FinancialException;

public interface TransactionController {
public ResponseEntity<Response> addTransaction(@RequestBody TransactionEntity transactionentity) throws FinancialException;
public ResponseEntity<List<TransactionEntity>> getAllTransaction(@PathVariable Long id) throws FinancialException;
public ResponseEntity<List<TransactionEntity>> getMiniStatement(@PathVariable Long id) throws FinancialException;
public ResponseEntity<Response> transferBal(@RequestBody TransactionEntity transactionentity) throws FinancialException;

}
