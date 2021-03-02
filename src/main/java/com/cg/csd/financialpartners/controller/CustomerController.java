package com.cg.csd.financialpartners.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.csd.financialpartners.entity.CustomerEntity;
import com.cg.csd.financialpartners.entity.Response;
import com.cg.csd.financialpartners.entity.UpdatePasword;
import com.cg.csd.financialpartners.exception.FinancialException;

public interface CustomerController {
public ResponseEntity<Response> addCustomer(@RequestBody CustomerEntity customerentity) throws FinancialException;
public ResponseEntity<Boolean> login(@PathVariable String mobno, @PathVariable String pwd);
public ResponseEntity<Response> updatePwd(@RequestBody UpdatePasword updatePasword) throws FinancialException;
}
