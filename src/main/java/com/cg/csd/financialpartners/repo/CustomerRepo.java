package com.cg.csd.financialpartners.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.csd.financialpartners.entity.CustomerEntity;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,Long>{
	
	public CustomerEntity findByCustomerMobileNoAndPassword(String mobno, String pwd);
	public CustomerEntity findByPancardNo(String pancardNo);
	public CustomerEntity findByCustomerMobileNo(String customerMobileNo);
	
}
