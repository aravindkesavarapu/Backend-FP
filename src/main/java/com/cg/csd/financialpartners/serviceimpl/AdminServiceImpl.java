package com.cg.csd.financialpartners.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.csd.financialpartners.entity.AdminDetails;
import com.cg.csd.financialpartners.exception.FinancialException;
import com.cg.csd.financialpartners.repo.AdminRepo;
import com.cg.csd.financialpartners.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	@Override
	public AdminDetails findByMobileNoAndPassword(Long mobileNo, String password) throws FinancialException {
		AdminDetails adminDetails = adminRepo.findByMobileNoAndPassword(mobileNo, password);
		if (adminDetails == null) {
			throw new FinancialException("Admin Details Not Found");
		} else {
			return adminDetails;
		}
	}

	@Override
	public AdminDetails register(AdminDetails adminDetails) {
		System.out.println(adminDetails);

		AdminDetails registeredDetails = adminRepo.saveAndFlush(adminDetails);
		return registeredDetails;
	}

}
