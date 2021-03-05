package com.cg.csd.financialpartners.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.csd.financialpartners.entity.BankAccountEntity;
import com.cg.csd.financialpartners.entity.Response;
import com.cg.csd.financialpartners.exception.FinancialException;

public interface BankAccountController {
public ResponseEntity<Response> addBankAccount(@RequestBody BankAccountEntity bankAccountEntity) throws FinancialException;
public ResponseEntity<List<BankAccountEntity>> findByCustomerId(Long customerId) throws FinancialException;
public ResponseEntity<Response> depositMoney(@PathVariable String accNo, double amount) throws FinancialException;

}
