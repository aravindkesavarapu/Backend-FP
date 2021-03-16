package com.cg.csd.financialpartners.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.csd.financialpartners.FinancialPartnersApplication;
import com.cg.csd.financialpartners.entity.TransactionEntity;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.repo.TransactionRepo;

@SpringBootTest(classes = FinancialPartnersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransactionServiceTest {

	private static final Logger Logger;

	static {
		Logger = LoggerFactory.getLogger(TransactionServiceTest.class);
	}

	public static Logger getLogger() {
		return Logger;
	}

	@Autowired
	private TransactionService transactionservice;
	@MockBean
	private TransactionRepo transactionrepo;

	@Test
	public void addTransactionTest() throws FinancialException {
		TransactionEntity transaction = new TransactionEntity(1l, 1l, "12345", "67890", "Debit", 
									LocalDate.now(), LocalTime.now(), 100l);
		when(transactionrepo.saveAndFlush(transaction)).thenReturn(transaction);
		TransactionEntity transaction1 = transactionservice.addTransction(transaction);
		assertNotNull(transaction1);
	}
	
	@Test
	public void getAllTransactionTest() throws FinancialException {
		List<TransactionEntity> list = new ArrayList<>();
		TransactionEntity transaction = new TransactionEntity(1l, 1l, "12345", "67890", "Debit", 
				LocalDate.now(), LocalTime.now(), 100l);
		list.add(transaction);
		when(transactionrepo.findByCustomerId(1l)).thenReturn(list);
		List<TransactionEntity> list1 = transactionservice.getAllTransaction(1l);
		assertEquals(list.size(), list1.size());
	}
	
	@Test
	public void getMiniStatementTest() throws FinancialException {
		List<TransactionEntity> list = new ArrayList<>();
		TransactionEntity transaction = new TransactionEntity(1l, 1l, "12345", "67890", "Debit", 
				LocalDate.now(), LocalTime.now(), 100l);
		list.add(transaction);
		when(transactionrepo.findByCustomerId(1l)).thenReturn(list);
		List<TransactionEntity> list1 = transactionservice.getMiniStatement(1l);
		assertNotEquals(0, list1.size());
	}
}