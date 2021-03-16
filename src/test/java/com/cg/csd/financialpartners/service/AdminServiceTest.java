package com.cg.csd.financialpartners.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.csd.financialpartners.FinancialPartnersApplication;
import com.cg.csd.financialpartners.entity.AdminDetails;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.repo.AdminRepo;

@SpringBootTest(classes = FinancialPartnersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminServiceTest {

	private static final Logger Logger;

	static {
		Logger = LoggerFactory.getLogger(AdminServiceTest.class);
	}

	public static Logger getLogger() {
		return Logger;
	}

	@Autowired
	private AdminService adminservice;
	@MockBean
	private AdminRepo adminrepo;

	@Test
	public void registerTest() throws FinancialException {
		AdminDetails admin = new AdminDetails(1l, "Sidd", "sidd123@gmail.com", 8298119487l, "qwerty123");
		when(adminrepo.saveAndFlush(admin)).thenReturn(admin);
		AdminDetails admin1 = adminservice.register(admin);
		assertEquals(admin, admin1);
	}
	
	@Test
	public void findByMobileNoAndPasswordTest() throws FinancialException {
		AdminDetails admin = new AdminDetails(1l, "Sidd", "sidd123@gmail.com", 8298119487l, "qwerty123");
		when(adminrepo.findByMobileNoAndPassword(8298119487l, "qwerty123")).thenReturn(admin);
		AdminDetails admin1 = adminservice.findByMobileNoAndPassword(8298119487l, "qwerty123");
		assertEquals(admin, admin1);
	}
}