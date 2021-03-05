package com.cg.csd.financialpartners.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.csd.financialpartners.entity.BankAccountEntity;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccountEntity, Long> {
	public BankAccountEntity findByAccountTypeAndCustomerId(String accType, Long customerId);
	public BankAccountEntity findByAccNo(String accNo);
	public List<BankAccountEntity> findByCustomerId(Long customerId);
	@Transactional
	@Modifying
	@Query("update BankAccountEntity b SET b.accBal = ?2 where b.accNo=?1 ")
	public int updateBal(String accNo,Double accBal);
	
	
}
