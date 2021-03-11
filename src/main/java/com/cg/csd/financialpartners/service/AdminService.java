package com.cg.csd.financialpartners.service;

import com.cg.csd.financialpartners.entity.AdminDetails;
import com.cg.csd.financialpartners.exception.FinancialException;

public interface AdminService {

	public AdminDetails findByMobileNoAndPassword(Long mobileNo, String password) throws FinancialException;
	public AdminDetails register(AdminDetails adminDetails) throws FinancialException;

}
