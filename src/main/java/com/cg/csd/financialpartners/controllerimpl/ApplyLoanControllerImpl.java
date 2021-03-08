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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.csd.financialpartners.controller.ApplyLoanController;
import com.cg.csd.financialpartners.controller.CustomerController;
import com.cg.csd.financialpartners.entity.ApplyLoanEntity;
import com.cg.csd.financialpartners.entity.CustomerEntity;
import com.cg.csd.financialpartners.entity.Response;
import com.cg.csd.financialpartners.entity.UpdatePasword;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.service.ApplyLoanService;
import com.cg.csd.financialpartners.service.CustomerService;

import io.micrometer.core.instrument.util.StringUtils;

@CrossOrigin("*")
@RestController
@RequestMapping("/applyLoan")
public class ApplyLoanControllerImpl implements ApplyLoanController {

	@Autowired
	private ApplyLoanService loanservice;

	private static final Logger logger;

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
		ApplyLoanEntity loanentity1 = loanservice.addLoan(loanentity);
		if (loanentity1 != null) {
			logger.debug("Loan Applied Successfully");
			r.setValue("Loan Applied Successfully, Please Check the Loan Status Loan EMI "+loanentity.getEmi());
			r.setStatus("SUCCESS");
			response3 = new ResponseEntity<>(r, HttpStatus.OK);
		} else {
			logger.error("Something Went Wrong");
			throw new FinancialException("Unable to Apply Loan");
		}
		return response3;
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

}
