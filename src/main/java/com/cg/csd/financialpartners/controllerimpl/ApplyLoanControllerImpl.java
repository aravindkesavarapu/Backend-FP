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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.csd.financialpartners.controller.ApplyLoanController;
import com.cg.csd.financialpartners.entity.ApplyLoanEntity;
import com.cg.csd.financialpartners.entity.BankAccountEntity;
import com.cg.csd.financialpartners.entity.Response;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.service.ApplyLoanService;
import com.cg.csd.financialpartners.service.BankAccountService;
import com.cg.csd.financialpartners.repo.ApplyLoanRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/applyLoan")
public class ApplyLoanControllerImpl implements ApplyLoanController {

	@Autowired
	private ApplyLoanService loanservice;

	private static final Logger logger;

	@Autowired
	private BankAccountService bankService;

	@Autowired
	private ApplyLoanRepo loanRepo;

	static {
		logger = LoggerFactory.getLogger(ApplyLoanControllerImpl.class);
	}
	ResponseEntity<ApplyLoanEntity> response1;
	ResponseEntity<Boolean> response2;
	ResponseEntity<Response> response3;

	Response r = new Response();

	@PostMapping("/addLoan")
	@Override
	public ResponseEntity<Response> addLoan(@RequestBody ApplyLoanEntity loanentity) throws FinancialException {
		BankAccountEntity bankAccountEntity = bankService.findByBankAccount(loanentity.getcAccNumber());
		if (bankAccountEntity.getCibil() <= 720) {
			r.setStatus("ERROR");
			r.setValue("Your CIBIL is Low!! You Can't apply for Loan");
			return new ResponseEntity<Response>(r, HttpStatus.OK);
		} else {
//			loanentity.setInterestRate(b);
			loanentity.setStatus("PENDING");
			loanentity.setCibil(bankAccountEntity.getCibil());
			loanentity.setCustomerName(bankAccountEntity.getCustomerName());
			ApplyLoanEntity loanentity1 = loanservice.addLoan(loanentity);
			if (loanentity1 != null) {
				logger.debug("Loan Applied Successfully");
				r.setValue("Loan Applied Successfully, Please Check the Loan Status Loan EMI " + loanentity.getEmi());
				r.setStatus("SUCCESS");
				response3 = new ResponseEntity<>(r, HttpStatus.OK);
				return response3;
			} else {
				logger.error("Something Went Wrong");
				throw new FinancialException("Unable to Apply Loan");
			}
		}
	}
     
	@GetMapping("/findByCId/{custId}")
	@Override
	public ResponseEntity<Response> findByCustID(@PathVariable Long custId) throws FinancialException {
		List<ApplyLoanEntity> list2 = loanservice.findByCustId(custId);
		if (list2 == null) {
			logger.error("No Loan Found");
			r.setValue("You have not applied for any Loan");
			r.setStatus("ERROR");
			response3 = new ResponseEntity<>(r, HttpStatus.OK);
		} else if (list2 != null) {
			logger.debug("Loan Found");
			r.setStatus("Success");
			r.setApplyLoan(list2);
			response3 = new ResponseEntity<>(r, HttpStatus.OK);
		}

		return response3;
	}

	@GetMapping("/admin/acceptLoan/{loanId}/{status}")
	public ResponseEntity<Response> updateLoanStatus(@PathVariable long loanId, @PathVariable String status)
			throws FinancialException {
		ApplyLoanEntity loanEntity = loanRepo.findById(loanId).get();
		if (loanEntity == null) {

			r.setStatus("ERROR");
			r.setValue("User Not Applied Loan");
			return new ResponseEntity<>(r, HttpStatus.OK);
		} else {

			loanEntity.setStatus(status);
			if (status == "APRROVED") {
				loanEntity.setStartDate(LocalDate.now());
				loanEntity.setEndDate(LocalDate.now().plusMonths(Long.parseLong(loanEntity.getDuration())));
				ApplyLoanEntity updatedLoan = loanservice.addLoan(loanEntity);
				r.setStatus("SUCESS");
				r.setValue("Set Status: " + updatedLoan.getStatus());
				return new ResponseEntity<Response>(r, HttpStatus.OK);
			} else {
				loanEntity.setStatus(status);
				r.setStatus("REJECTED");
				ApplyLoanEntity updatedLoan = loanservice.addLoan(loanEntity);
				return new ResponseEntity<Response>(r, HttpStatus.OK);

			}
		}
	}

	@GetMapping("/admin/getAllLoanDetails")
	public ResponseEntity<Response> getAllLoan() throws FinancialException {
		List<ApplyLoanEntity> allLoan = loanRepo.findByStatus("PENDING");
		r.setApplyLoan(allLoan);
		r.setStatus("SUCESS");
		r.setApplyLoan(allLoan);
		return new ResponseEntity<Response>(r, HttpStatus.OK);
	}

}
