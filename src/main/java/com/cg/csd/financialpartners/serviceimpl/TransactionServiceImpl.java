package com.cg.csd.financialpartners.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.csd.financialpartners.controllerimpl.TransactionControllerImpl;
import com.cg.csd.financialpartners.entity.BankAccountEntity;
import com.cg.csd.financialpartners.entity.TransactionEntity;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.repo.BankAccountRepo;
import com.cg.csd.financialpartners.repo.TransactionRepo;
import com.cg.csd.financialpartners.service.BankAccountService;
import com.cg.csd.financialpartners.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	private static final Logger logger;

	@Autowired
	private TransactionRepo transactionRepo;
	@Autowired
	private BankAccountService bankAccountService;
	static {
		logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	}

	@Override
	public TransactionEntity addTransction(TransactionEntity transactionEntity) throws FinancialException {

		logger.info("I am in Transction Service Impl");
		return transactionRepo.saveAndFlush(transactionEntity);
	}

	@Override
	public List<TransactionEntity> getAllTransaction(Long customerId) {
		if (transactionRepo.findByCustomerId(customerId).isEmpty()) {
			return null;
		} else {
			return transactionRepo.findByCustomerId(customerId);
		}
	}

	@Override
	public List<TransactionEntity> getMiniStatement(Long customerId) {
		List<TransactionEntity> list = getAllTransaction(customerId);
		if (list.isEmpty()) {
			return null;
		} else {
			List<TransactionEntity> list1 = new ArrayList<>();
			if (list.size() < 5) {
				for (int i = 0; i < list.size(); i++) {
					list1.add(list.get(i));
				}
			} else {
				for (int i = 0; i < 5; i++) {
					list1.add(list.get(i));
				}
			}
			return list1;
		}
	}

	@Override
	public TransactionEntity transfer(TransactionEntity transactionEntity) {

		logger.info(
				"I am in Transction Service Impl TranferEntity Method, trying search bank account no in BankAccountEntity");
		BankAccountEntity findByAccNo = bankAccountService
				.findByBankAccount(String.valueOf(transactionEntity.getFromAcc()));

		if (findByAccNo == null) {
			logger.warn("I am in Transction Service Impl TranferEntity Method, Bank Acount NOTFOUND for bank Accunt"
					+ transactionEntity.getFromAcc());
			return null;
		} else {
			if (findByAccNo.getAccBal() < transactionEntity.gettAmount()) {

			}

		}

		return null;
	}

}
