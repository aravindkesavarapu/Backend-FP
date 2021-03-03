package com.cg.csd.financialpartners.controllerimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.csd.financialpartners.controller.BankAccountController;
import com.cg.csd.financialpartners.entity.BankAccountEntity;
import com.cg.csd.financialpartners.entity.CustomerEntity;
import com.cg.csd.financialpartners.entity.Response;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.repo.CustomerRepo;
import com.cg.csd.financialpartners.service.BankAccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/bankAccount")
public class BankAccountControllerImpl implements BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;

	private static final Logger logger;

	static {
		logger = LoggerFactory.getLogger(BankAccountControllerImpl.class);
	}
	ResponseEntity<BankAccountEntity> response1;
	ResponseEntity<Boolean> response2;
	ResponseEntity<Response> response3;
	ResponseEntity<List<BankAccountEntity>> response4;

	Response r = new Response();

	@Autowired
	CustomerRepo customerRepo;

	@PostMapping("/addAccount")
	@Override
	public ResponseEntity<Response> addBankAccount(@RequestBody BankAccountEntity bankAccountEntity)
			throws FinancialException {
		if (bankAccountService.findByAccoutTypeAndCustomerId(bankAccountEntity.getAccountType().toUpperCase(),
				bankAccountEntity.getCustomerId()) != null) {
			r.setValue("You already have a " + bankAccountEntity.getAccountType() + " account");
			logger.error("You already have a " + bankAccountEntity.getAccountType() + " account");
			response3 = new ResponseEntity<>(r, HttpStatus.OK);
		} else {
			bankAccountEntity.setAccNo(bankAccountService.generateAccountNo(bankAccountEntity.getCustomerId()));
			bankAccountEntity.setAccountType(bankAccountEntity.getAccountType().toUpperCase());

			bankAccountEntity.setCibil(15l);
			BankAccountEntity bankAccountEntity1 = bankAccountService.addBankAccount(bankAccountEntity);

			if (bankAccountEntity1 == null) {
				logger.error("failed to add bank account");
				throw new FinancialException("failed to add bank account");
			} else {
				logger.debug(bankAccountEntity1.toString());

				List<BankAccountEntity> accountEntities = bankAccountService
						.findByCustomerId(bankAccountEntity.getCustomerId());

				r.setValue("Your " + bankAccountEntity.getAccountType() + " account number is "
						+ bankAccountEntity1.getAccNo());
				r.setBankAccount(accountEntities);
//			r.setValue("Successfully Register");
				r.setStatus("200");
				response3 = new ResponseEntity<>(r, HttpStatus.OK);
			}
		}
		return response3;
	}

	@GetMapping("/findByCustomerId/{customerId}")
	@Override
	public ResponseEntity<List<BankAccountEntity>> findByCustomerId(@PathVariable Long customerId)
			throws FinancialException {
		List<BankAccountEntity> list1 = bankAccountService.findByCustomerId(customerId);
		if (list1.isEmpty()) {
			throw new FinancialException("You don't have any account");
		} else {
			response4 = new ResponseEntity<>(list1, HttpStatus.OK);
		}
		return response4;
	}

	@GetMapping("findByCustomerIdSavings/{customerId}")
	public ResponseEntity<BankAccountEntity> findByAcccount(@PathVariable long customerId) {
		BankAccountEntity bank = bankAccountService.findByAccoutTypeAndCustomerId("SAVINGS", customerId);
		return new ResponseEntity<BankAccountEntity>(bank, HttpStatus.OK);
	}

}