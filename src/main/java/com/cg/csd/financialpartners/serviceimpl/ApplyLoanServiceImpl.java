package com.cg.csd.financialpartners.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.csd.financialpartners.entity.ApplyLoanEntity;
import com.cg.csd.financialpartners.repo.ApplyLoanRepo;
import com.cg.csd.financialpartners.service.ApplyLoanService;

@Service
public class ApplyLoanServiceImpl implements ApplyLoanService {

	@Autowired
	private ApplyLoanRepo loanrepo;

	@Override
	public ApplyLoanEntity addLoan(ApplyLoanEntity loanentity) {
		return loanrepo.saveAndFlush(loanentity);
	}

	@Override
	public List<ApplyLoanEntity> findByCustId(Long custId) {
		List<ApplyLoanEntity> list1 = loanrepo.findByCustId(custId);
		if (list1.isEmpty()) {
			return null;
		} 
		else {
			return list1;
		}
	}

}
