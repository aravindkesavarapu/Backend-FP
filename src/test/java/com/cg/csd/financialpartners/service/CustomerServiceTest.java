package com.cg.csd.financialpartners.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.csd.financialpartners.FinancialPartnersApplication;
import com.cg.csd.financialpartners.entity.CustomerEntity;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.repo.CustomerRepo;

@SpringBootTest(classes = FinancialPartnersApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerServiceTest{
	
	private static final Logger Logger;

	static {
		Logger = LoggerFactory.getLogger(CustomerServiceTest.class);
	}

	public static Logger getLogger() {
		return Logger;
	}
	
	@Autowired
	private CustomerService customerservice;
	@MockBean
	private CustomerRepo customerrepo;
	
	@Test
	public void registrationTest() throws FinancialException {
		CustomerEntity customer = new CustomerEntity(1l, "Siddharth", "Male", "Mumbai", "21/03/1997", "8298119487", 
						"sidd123@gmail.com", "Dsjjs", "QWERTY123", "ABC1234");
	when(customerrepo.saveAndFlush(customer)).thenReturn(customer);
	CustomerEntity customer1 = customerservice.registration(customer);
	assertNotNull(customer1);
	}
}