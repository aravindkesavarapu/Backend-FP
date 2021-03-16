package com.cg.csd.financialpartners.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.csd.financialpartners.FinancialPartnersApplication;
import com.cg.csd.financialpartners.entity.ApplyLoanEntity;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.repo.ApplyLoanRepo;

@SpringBootTest(classes = FinancialPartnersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplyLoanServiceTest {

	private static final Logger Logger;

	static {
		Logger = LoggerFactory.getLogger(ApplyLoanServiceTest.class);
	}

	public static Logger getLogger() {
		return Logger;
	}

	@Autowired
	private ApplyLoanService loanservice;
	@MockBean
	private ApplyLoanRepo loanrepo;

	@Test
	public void addLoanTest() throws FinancialException {
		ApplyLoanEntity loan = new ApplyLoanEntity(1l, "123456789", 500.00, "Sidd", 400.45, 6.00, "6 months", 100.75,
				"Xyz", "Approved", LocalDate.now(), LocalDate.now(), 1l, 1000.00, "Qwertyuiop");
		when(loanrepo.saveAndFlush(loan)).thenReturn(loan);
		ApplyLoanEntity loan1 = loanservice.addLoan(loan);
		assertEquals(loan, loan1);
	}

	@Test
	public void findByCustIdTest() throws FinancialException {
		List<ApplyLoanEntity> list = new ArrayList<>();
		ApplyLoanEntity loan = new ApplyLoanEntity(1l, "123456789", 500.00, "Sidd", 400.45, 6.00, "6 months", 100.75,
				"Xyz", "Approved", LocalDate.now(), LocalDate.now(), 1l, 1000.00, "Qwertyuiop");
		list.add(loan);
		when(loanrepo.findByCustId(1l)).thenReturn(list);
		List<ApplyLoanEntity> list1 = loanservice.findByCustId(1l);
		assertEquals(list.size(), list1.size());
	}
}