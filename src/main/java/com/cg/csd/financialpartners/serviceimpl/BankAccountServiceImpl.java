package com.cg.csd.financialpartners.serviceimpl;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.csd.financialpartners.entity.BankAccountEntity;
import com.cg.csd.financialpartners.repo.BankAccountRepo;
import com.cg.csd.financialpartners.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepo bankAccountRepo;

	@Override
	public BankAccountEntity addBankAccount(BankAccountEntity bankAccountEntity) {
		return bankAccountRepo.saveAndFlush(bankAccountEntity);

	}

	@Override
	public String generateAccountNo(long id) {
		Random r = new Random();
		long accNo = (long) (100000000000l + id + ThreadLocalRandom.current().nextDouble() * 1000);
		String s = Long.toString(accNo);
		return s;
	}

	@Override
	public BankAccountEntity findByAccoutTypeAndCustomerId(String accType, Long customerId) {
		if (bankAccountRepo.findByAccountTypeAndCustomerId(accType, customerId) == null) {
			return null;
		}

		else {
			return bankAccountRepo.findByAccountTypeAndCustomerId(accType, customerId);
		}
	}

	@Override
	public List<BankAccountEntity> findByCustomerId(Long customerId) {

		return bankAccountRepo.findByCustomerId(customerId);

	}

}
