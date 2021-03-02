package com.cg.csd.financialpartners.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.csd.financialpartners.entity.BankAccountEntity;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccountEntity, Long> {
	public BankAccountEntity findByAccountTypeAndCustomerId(String accType, Long customerId);

	public List<BankAccountEntity> findByCustomerId(Long customerId);
}
