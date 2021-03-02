package com.cg.csd.financialpartners.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.csd.financialpartners.entity.TransactionEntity;
import com.cg.csd.financialpartners.repo.TransactionRepo;
import com.cg.csd.financialpartners.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepo transactionRepo;

	@Override
	public TransactionEntity addTransaction(TransactionEntity transactionEntity) {

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

}
