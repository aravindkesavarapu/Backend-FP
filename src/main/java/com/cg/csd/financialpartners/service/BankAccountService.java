package com.cg.csd.financialpartners.service;

import java.util.List;

import com.cg.csd.financialpartners.entity.BankAccountEntity;

public interface BankAccountService {
	public BankAccountEntity addBankAccount(BankAccountEntity bankAccountEntity);

	public String generateAccountNo(long id);
	public BankAccountEntity findByAccoutTypeAndCustomerId(String accType, Long customerId);
	public List<BankAccountEntity> findByCustomerId(Long customerId);
	public BankAccountEntity findByBankAccount(String accNo);
	public int updateBal(double accBal, String accNo);

}
