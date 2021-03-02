package com.cg.csd.financialpartners.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.csd.financialpartners.entity.CustomerEntity;
import com.cg.csd.financialpartners.repo.CustomerRepo;
import com.cg.csd.financialpartners.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo repo;

	@Override
	public CustomerEntity registration(CustomerEntity customerentity) {
		// TODO Auto-generated method stub
		return repo.saveAndFlush(customerentity);
	}

	@Override
	public CustomerEntity login(String mobno, String pwd) {
		// TODO Auto-generated method stub
		return repo.findByCustomerMobileNoAndPassword(mobno, pwd);
	}

	public String generatePwd() {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(6);
		for (int i = 0; i < 6; i++) {
			int index = (int) (str.length() * Math.random());
			sb.append(str.charAt(index));
		}
		return sb.toString();
	}

	@Override
	public CustomerEntity updatePwd(String customerMobileNo, String oldPassword, String newPassword) {

		System.out.println("From cusotmer Service" + customerMobileNo);
		CustomerEntity customerentity1 = repo.findByCustomerMobileNoAndPassword(customerMobileNo, oldPassword);
		if (customerentity1 != null) {

			customerentity1.setPassword(newPassword);
			return repo.saveAndFlush(customerentity1);
		} else {
			return null;
		}
	}

	@Override
	public CustomerEntity findByPancardNo(String pancardNo) {
		if (repo.findByPancardNo(pancardNo) != null) {
			return repo.findByPancardNo(pancardNo);
		} else {
			return null;
		}
	}

	@Override
	public CustomerEntity findByCustomerMobileNo(String customerMobileNo) {
		CustomerEntity customerDetails = repo.findByCustomerMobileNo(customerMobileNo);
		if (customerDetails == null) {
			return null;
		} else {
			return customerDetails;
		}
	}
}
