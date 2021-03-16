package com.cg.csd.financialpartners.service;

import com.cg.csd.financialpartners.entity.CustomerEntity;

public interface CustomerService {
public CustomerEntity registration(CustomerEntity customerentity);
public CustomerEntity login(String mobno, String pwd);
public CustomerEntity findByPancardNo(String pancardNo);
public CustomerEntity findByCustomerMobileNo(String customerMobileNo);
public String generatePwd();
CustomerEntity updatePwd(String customerMobileNo, String oldPassword, String newPassword);
}
