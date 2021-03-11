package com.cg.csd.financialpartners.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.csd.financialpartners.entity.AdminDetails;

@Repository
public interface AdminRepo extends JpaRepository<AdminDetails, Long>{
	public AdminDetails findByMobileNoAndPassword(Long mobileNo, String password);
	
}
