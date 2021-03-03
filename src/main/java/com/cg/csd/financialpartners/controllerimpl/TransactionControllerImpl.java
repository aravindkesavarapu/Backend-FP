package com.cg.csd.financialpartners.controllerimpl;

import java.time.LocalDate;
import java.time.LocalTime;
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

import com.cg.csd.financialpartners.controller.TransactionController;
import com.cg.csd.financialpartners.entity.BankAccountEntity;
import com.cg.csd.financialpartners.entity.Response;
import com.cg.csd.financialpartners.entity.TransactionEntity;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.service.BankAccountService;
import com.cg.csd.financialpartners.service.TransactionService;
import com.cg.csd.financialpartners.serviceimpl.BankAccountServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/transaction")
public class TransactionControllerImpl implements TransactionController {

	@Autowired
	private TransactionService service1;

	private static final Logger logger;

	@Autowired
	private BankAccountService bankService;

	static {
		logger = LoggerFactory.getLogger(TransactionControllerImpl.class);
	}
	ResponseEntity<TransactionEntity> response1;
	ResponseEntity<List<TransactionEntity>> response2;
	ResponseEntity<Response> response3;

	Response r = new Response();

	// Aravind this method to deposit implemetation
	@PostMapping("/addTransaction")
	@Override
	public ResponseEntity<Response> addTransaction(@RequestBody TransactionEntity transactionentity)
			throws FinancialException {
//		if(transactionentity.getCustomerId() == null || transactionentity.getFromAcc() == null ||  transactionentity.gettType() == null) {
//			r.setValue("Unable to process your transaction");
//			logger.error("Transaction failed null value" + transactionentity);
//			response3 = new ResponseEntity<>(r,HttpStatus.BAD_REQUEST);
//			throw new FinancialException("Transaction failed");
//		}
//		else {
//			transactionentity.settDate(LocalDate.now());
//			transactionentity.settTime(LocalTime.now());
//			BankAccountEntity bankDetails = service1.addBal(transactionentity);
//			if(bankDetails == null) {
//				logger.error("Transaction failed" + bankDetails);
//				r.setValue("Unable to process your transaction or Please Login again");
//				response3 = new ResponseEntity<Response>(r,HttpStatus.EXPECTATION_FAILED);
//			}
//			else {
//				logger.info("Transction Amount" + transactionentity.gettAmount());
//				logger.info("Transction Suceccfull and Bank Account Details" + bankDetails);
//				r.setValue("Transaction Successful");
//				response3 = new ResponseEntity<>(r,HttpStatus.OK);
//			}
//		}
		return response3;
	}

	@GetMapping("/getAllTransaction/{id}")
	@Override
	public ResponseEntity<List<TransactionEntity>> getAllTransaction(@PathVariable Long id) throws FinancialException {
		List<TransactionEntity> list2 = service1.getAllTransaction(id);
		if (list2 == null) {
			logger.error("No transaction found");
			response2 = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			throw new FinancialException("No transaction found");
		} else {
			response2 = new ResponseEntity<>(list2, HttpStatus.OK);
		}
		return response2;
	}

	@GetMapping("/getMiniStatement/{id}")
	@Override
	public ResponseEntity<List<TransactionEntity>> getMiniStatement(@PathVariable Long id) throws FinancialException {
		List<TransactionEntity> list3 = service1.getMiniStatement(id);
		if (list3 == null) {
			logger.error("No transaction found");
			response2 = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			throw new FinancialException("No transaction found");
		} else {
			response2 = new ResponseEntity<>(list3, HttpStatus.OK);
		}

		return response2;
	}

	@PostMapping("/transfer")
	@Override
	public ResponseEntity<Response> transferBal(@RequestBody TransactionEntity transactionentity)
			throws FinancialException {
		BankAccountEntity fromAcc = bankService.findByBankAccount(transactionentity.getFromAcc());
		if (fromAcc != null) {
			BankAccountEntity toAcc = bankService.findByBankAccount(transactionentity.getToAcc());
			if (toAcc == null) {
				r.setValue("Please Check your transfeering Account No: " + transactionentity.getToAcc());
				response3 = new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
			} else if (fromAcc.getAccBal() < transactionentity.gettAmount()) {
				logger.info("Account balance is low");
				r.setValue("Account Balance is Less than your transction amount");
				response3 = new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
			} else {
				logger.info("Transferring Amount ");

				Long fromAccountCustomerId = fromAcc.getCustomerId();
				transactionentity.setCustomerId(fromAccountCustomerId);
				transactionentity.settDate(LocalDate.now());
				transactionentity.settTime(LocalTime.now());
				transactionentity.settType("DEBIT");
				TransactionEntity transfer1 = service1.addTransction(transactionentity);
					
				TransactionEntity t2 = new TransactionEntity();
				t2.setCustomerId(toAcc.getCustomerId());
				t2.settDate(LocalDate.now());
				t2.settTime(LocalTime.now());
				t2.settAmount(transactionentity.gettAmount());
				t2.settType("CREDIT");
				t2.setFromAcc(transactionentity.getFromAcc());
				t2.setToAcc(transactionentity.getToAcc());
				TransactionEntity transfer2 = service1.addTransction(t2);
				System.err.println(transfer2);
				
				fromAcc.setAccBal(fromAcc.getAccBal() - transactionentity.gettAmount());
				toAcc.setAccBal(toAcc.getAccBal() + transactionentity.gettAmount());
				bankService.updateBal(fromAcc.getAccBal(), fromAcc.getAccNo());
				bankService.updateBal(toAcc.getAccBal(), toAcc.getAccNo());
				r.setValue("Amount Transferred to: " + toAcc.getAccNo());
				response3 = new ResponseEntity<>(r, HttpStatus.OK);
			}

		} else {
			logger.info("Im in trasnction controller Impl transfer method fromacc NOTFOUND or NULL");
			throw new FinancialException("Some thing went Wrong");
		}
		return response3;
	}

}
