package com.cg.csd.financialpartners.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.csd.financialpartners.entity.ApplyLoanEntity;
import com.cg.csd.financialpartners.entity.Response;
import com.cg.csd.financialpartners.exception.FinancialException;

public interface ApplyLoanController {
public ResponseEntity<Response> addLoan(@RequestBody ApplyLoanEntity loanentity) throws FinancialException;
public ResponseEntity<Response> findByCustID(@PathVariable Long custId) throws FinancialException;
public ResponseEntity<Response> updateLoanStatus(@RequestBody ApplyLoanEntity entity) throws FinancialException;

}
