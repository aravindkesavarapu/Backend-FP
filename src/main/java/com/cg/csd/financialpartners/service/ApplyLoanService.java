package com.cg.csd.financialpartners.service;

import java.util.List;

import com.cg.csd.financialpartners.entity.ApplyLoanEntity;

public interface ApplyLoanService {

	public ApplyLoanEntity addLoan(ApplyLoanEntity loanentity);
	public List<ApplyLoanEntity> findByCustId(Long custId);
}
