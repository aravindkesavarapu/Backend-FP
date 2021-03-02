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
import com.cg.csd.financialpartners.entity.Response;
import com.cg.csd.financialpartners.entity.TransactionEntity;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.service.TransactionService;

@CrossOrigin("*")
@RestController
@RequestMapping("/transaction")
public class TransactionControllerImpl implements TransactionController {

	@Autowired
	private TransactionService service1;
	
    private static final Logger logger;
	
	static {
		logger= LoggerFactory.getLogger(TransactionControllerImpl.class);
	}
	ResponseEntity<TransactionEntity> response1;
	ResponseEntity<List<TransactionEntity>> response2;
    ResponseEntity<Response> response3;

    Response r = new Response();
    
    @PostMapping("/addTransaction")
	@Override
	public ResponseEntity<Response> addTransaction(@RequestBody TransactionEntity transactionentity) throws FinancialException {
		if(transactionentity.getCustomerId() == null || transactionentity.getFromAcc() == null || 
				transactionentity.getToAcc() == null || transactionentity.gettType() == null) {
			r.setValue("Unable to process your transaction");
			logger.error("Transaction failed null value" + transactionentity);
			response3 = new ResponseEntity<>(r,HttpStatus.BAD_REQUEST);
			throw new FinancialException("Transaction failed");
		}
		else {
			transactionentity.settDate(LocalDate.now());
			transactionentity.settTime(LocalTime.now());
			TransactionEntity transactionentity1 = service1.addTransaction(transactionentity);
			if(transactionentity1 == null) {
				logger.error("Transaction failed" + transactionentity1);
				r.setValue("Unable to process your transaction");
				response3 = new ResponseEntity<Response>(r,HttpStatus.EXPECTATION_FAILED);
			}
			else {
				logger.debug("Successful" + transactionentity1);
				r.setValue("Transaction Successful");
				response3 = new ResponseEntity<>(r,HttpStatus.OK);
			}
		}
		return response3;
	}
    @GetMapping("/getAllTransaction/{id}")
	@Override
	public ResponseEntity<List<TransactionEntity>> getAllTransaction(@PathVariable Long id) throws FinancialException {
		List<TransactionEntity> list2 = service1.getAllTransaction(id);
		if(list2 == null) {
			logger.error("No transaction found");
			response2 = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			throw new FinancialException("No transaction found");	
		}
		else {
			response2 = new ResponseEntity<>(list2, HttpStatus.OK);	
		}
		return response2;
	}
    @GetMapping("/getMiniStatement/{id}")
	@Override
	public ResponseEntity<List<TransactionEntity>> getMiniStatement(@PathVariable Long id) throws FinancialException {
		List<TransactionEntity> list3 = service1.getMiniStatement(id);
		if(list3 == null) {
			logger.error("No transaction found");
			response2 = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			throw new FinancialException("No transaction found");	
		}
		else {
			response2 = new ResponseEntity<>(list3, HttpStatus.OK);	
		}
		
		return response2;
	}
    
    
}
