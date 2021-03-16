package com.cg.csd.financialpartners.controllerimpl;

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

import com.cg.csd.financialpartners.controller.CustomerController;
import com.cg.csd.financialpartners.entity.CustomerEntity;
import com.cg.csd.financialpartners.entity.Response;
import com.cg.csd.financialpartners.entity.UpdatePasword;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.service.CustomerService;

import io.micrometer.core.instrument.util.StringUtils;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerControllerImpl implements CustomerController {

	@Autowired
	private CustomerService service;

	private static final Logger logger;

	static {
		logger = LoggerFactory.getLogger(CustomerControllerImpl.class);
	}
	ResponseEntity<CustomerEntity> response1;
	ResponseEntity<Boolean> response2;
	ResponseEntity<Response> response3;

	Response r = new Response();

	@PostMapping("/addUser")
	@Override
	public ResponseEntity<Response> addCustomer(@RequestBody CustomerEntity customerentity) throws FinancialException {

		try {

			if (customerentity == null) {
				logger.error(customerentity + "   entered Customer is null");
				response3 = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				throw new FinancialException("invalid customer data");
			} else if (StringUtils.isBlank(customerentity.getCustomerEmailId())) {
				logger.error(customerentity + "   not given any email");
				response3 = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				throw new FinancialException("please give an email");
			} else if (StringUtils.isBlank(customerentity.getCustomerMobileNo())) {
				logger.error(customerentity + "   not given any phone number");
				response3 = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				throw new FinancialException("please give a phone number");

			} else if (service.findByCustomerMobileNo(customerentity.getCustomerMobileNo()) != null) {
				r.setValue("customer already exists");
				logger.error(customerentity + "   customer already exists");
				response3 = new ResponseEntity<>(r, HttpStatus.OK);
			}

			else if (customerentity.getPancardNo() == null) {
				logger.error(customerentity + "   not given any pancard number");
				response3 = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				throw new FinancialException("please give a pancard number");
			}

			else if (service.findByPancardNo(customerentity.getPancardNo()) != null) {
				r.setValue("customer already exists");
				logger.error(customerentity + "   customer already exists");
				response3 = new ResponseEntity<>(r, HttpStatus.OK);
			}

			else {

				String generatedPwd = service.generatePwd();
				customerentity.setPassword(generatedPwd);
				CustomerEntity customerentity1 = service.registration(customerentity);
				r.setValue("Your Login id is : " + customerentity1.getCustomerMobileNo() + "\n" + "Your Password is : "
						+ customerentity1.getPassword());
//		    r.setcEntity(customerentity1);;
				response3 = new ResponseEntity<>(r, HttpStatus.OK);
			}

		} catch (FinancialException e) {
			logger.error(e + " Registration problem");
			response3 = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response3;
	}

	@GetMapping("/login/{mobno}/{pwd}")
	@Override
	public ResponseEntity<Boolean> login(@PathVariable String mobno, @PathVariable String pwd) {
		CustomerEntity customerentity = service.login(mobno, pwd);
		if (customerentity == null) {
			logger.error(customerentity + "   not given any phone number");
			response2 = new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
		} else {
			response2 = new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		}
		return response2;
	}

	@CrossOrigin("*")
	@Override
	@PostMapping("/updatePwd")
	public ResponseEntity<Response> updatePwd(@RequestBody UpdatePasword updatePassword) throws FinancialException {
		CustomerEntity customerentity1 = service.updatePwd(updatePassword.getCustomerMobileNo(),
				updatePassword.getPassword(), updatePassword.getNewpassword());

		if (customerentity1 == null) {
			logger.debug("failed");
			r.setValue("Some Thing went wrong PLease check password");
			response3 = new ResponseEntity<>(r, HttpStatus.OK);
		} else {

			logger.debug("Password Updated sucess");
			r.setValue("Password updated successfully");
			response3 = new ResponseEntity<>(r, HttpStatus.OK);
		}
		return response3;
	}

	@GetMapping("/getCustomerDetails/{customerMobileNo}")
	public ResponseEntity<CustomerEntity> getCustomerDetails(@PathVariable String customerMobileNo) {
		CustomerEntity customerDetails = service.findByCustomerMobileNo(customerMobileNo);
		if (customerDetails == null) {
			return new ResponseEntity<CustomerEntity>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<CustomerEntity>(customerDetails, HttpStatus.OK);
		}
	}
}
