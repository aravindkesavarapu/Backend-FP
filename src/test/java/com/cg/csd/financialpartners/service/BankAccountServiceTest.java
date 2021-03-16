package com.cg.csd.financialpartners.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.csd.financialpartners.FinancialPartnersApplication;
import com.cg.csd.financialpartners.entity.BankAccountEntity;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.repo.BankAccountRepo;

@SpringBootTest(classes = FinancialPartnersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BankAccountServiceTest {

	private static final Logger Logger;

	static {
		Logger = LoggerFactory.getLogger(BankAccountServiceTest.class);
	}

	public static Logger getLogger() {
		return Logger;
	}

	@Autowired
	private BankAccountService accservice;
	@MockBean
	private BankAccountRepo accrepo;

	@Test
	public void addBankAccountTest() throws FinancialException {
		BankAccountEntity bank = new BankAccountEntity(1l, "123456789", 1l, 100.00, "ABC123", "Aadhar", 1l, 500.25,
				"Capg", "Savings", "Sidd");
		when(accrepo.saveAndFlush(bank)).thenReturn(bank);
		BankAccountEntity bank1 = accservice.addBankAccount(bank);
		assertNotNull(bank1);
	}

	@Test
	public void findByAccoutTypeAndCustomerIdTest() throws FinancialException {
		BankAccountEntity bank = new BankAccountEntity(1l, "123456789", 1l, 100.00, "ABC123", "Aadhar", 1l, 500.25,
				"Capg", "Savings", "Sidd");
		when(accrepo.findByAccountTypeAndCustomerId("Savings", 1l)).thenReturn(bank);
		BankAccountEntity bank1 = accservice.findByAccoutTypeAndCustomerId("Savings", 1l);
		assertEquals(bank, bank1);
	}

	@Test
	public void findByCustomerIdTest() throws FinancialException {
		List<BankAccountEntity> list = new ArrayList<>();
		BankAccountEntity bank = new BankAccountEntity(1l, "123456789", 1l, 100.00, "ABC123", "Aadhar", 1l, 500.25,
				"Capg", "Savings", "Sidd");
		list.add(bank);
		when(accrepo.findByCustomerId(1l)).thenReturn(list);
		List<BankAccountEntity> list1 = accservice.findByCustomerId(1l);
		assertEquals(list.size(), list1.size());
	}

	@Test
	public void findByBankAccountTest() throws FinancialException {
		BankAccountEntity bank = new BankAccountEntity(1l, "123456789", 1l, 100.00, "ABC123", "Aadhar", 1l, 500.25,
				"Capg", "Savings", "Sidd");
		when(accrepo.findByAccNo("123456789")).thenReturn(bank);
		BankAccountEntity bank1 = accservice.findByBankAccount("123456789");
		assertEquals(bank, bank1);
	}
}