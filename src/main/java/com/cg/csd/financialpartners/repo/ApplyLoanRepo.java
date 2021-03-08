package com.cg.csd.financialpartners.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.csd.financialpartners.entity.ApplyLoanEntity;

@Repository
public interface ApplyLoanRepo extends JpaRepository<ApplyLoanEntity, Long> {
	public List<ApplyLoanEntity> findByCustId(Long custId);
}
