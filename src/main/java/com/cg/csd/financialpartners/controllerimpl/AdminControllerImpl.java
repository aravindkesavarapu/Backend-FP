package com.cg.csd.financialpartners.controllerimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.csd.financialpartners.entity.AdminDetails;
import com.cg.csd.financialpartners.entity.Response;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.service.AdminService;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminControllerImpl {

	private static Logger log;
	static {
		log = LoggerFactory.getLogger(TransactionControllerImpl.class);
	}
	@Autowired
	private AdminService adminService;

	Response response = new Response();
	
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody AdminDetails adminDetails) throws FinancialException {
		AdminDetails adminData = adminService.findByMobileNoAndPassword(adminDetails.getMobileNo(),
				adminDetails.getPassword());
		if (adminData == null) {
			response.setStatus("ERROR");
			response.setValue("ADMIN LOGGEDIN FAILED!! Please check Credentails");
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		} else {
			response.setValue("ADMIN LOGGEDIN SCUESS");
			response.setAdmin(adminData);
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody AdminDetails adminDetails) throws
	FinancialException{
		System.out.println(adminDetails);
		AdminDetails adminData =adminService.register(adminDetails);
		if(adminData == null) {
			response.setStatus("ERROR");
			response.setValue("ADMIN REGISTRATION FAILED!!");
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		} else {
			response.setValue("ADMIN REGISTERED SCUESS");
			response.setAdmin(adminData);
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
	}
	

}
