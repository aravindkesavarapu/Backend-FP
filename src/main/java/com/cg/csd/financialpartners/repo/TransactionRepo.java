package com.cg.csd.financialpartners.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.csd.financialpartners.entity.TransactionEntity;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionEntity,Long>{
	
	public List<TransactionEntity> findByCustomerId(Long customerId);
	
}
