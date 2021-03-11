package com.cg.csd.financialpartners.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Response {

	private String value;
	private String status;
	private List<BankAccountEntity> bankAccount;
	private BankAccountEntity account;
	private CustomerEntity cEntity;
	private List<TransactionEntity> transactionEntities;
	private List<ApplyLoanEntity> applyLoan;
	private AdminDetails admin;
	
	public Response(String value, String status, List<BankAccountEntity> bankAccount, BankAccountEntity account,
			CustomerEntity cEntity, List<TransactionEntity> transactionEntities, List<ApplyLoanEntity> applyLoan,
			AdminDetails admin) {
		super();
		this.value = value;
		this.status = status;
		this.bankAccount = bankAccount;
		this.account = account;
		this.cEntity = cEntity;
		this.transactionEntities = transactionEntities;
		this.applyLoan = applyLoan;
		this.admin = admin;
	}

	public BankAccountEntity getAccount() {
		return account;
	}

	public void setAccount(BankAccountEntity account) {
		this.account = account;
	}

	public AdminDetails getAdmin() {
		return admin;
	}

	public void setAdmin(AdminDetails admin) {
		this.admin = admin;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BankAccountEntity> getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(List<BankAccountEntity> bankAccount) {
		this.bankAccount = bankAccount;
	}

	public CustomerEntity getcEntity() {
		return cEntity;
	}

	public void setcEntity(CustomerEntity cEntity) {
		this.cEntity = cEntity;
	}

	public List<TransactionEntity> getTransactionEntities() {
		return transactionEntities;
	}

	public void setTransactionEntities(List<TransactionEntity> transactionEntities) {
		this.transactionEntities = transactionEntities;
	}

	public List<ApplyLoanEntity> getApplyLoan() {
		return applyLoan;
	}

	public void setApplyLoan(List<ApplyLoanEntity> applyLoan) {
		this.applyLoan = applyLoan;
	}

	@Override
	public String toString() {
		return "Response [value=" + value + ", status=" + status + ", bankAccount=" + bankAccount + ", account="
				+ account + ", cEntity=" + cEntity + ", transactionEntities=" + transactionEntities + ", applyLoan="
				+ applyLoan + ", admin=" + admin + "]";
	}

	public Response(String value, String status, List<BankAccountEntity> bankAccount, CustomerEntity cEntity,
			List<TransactionEntity> transactionEntities, List<ApplyLoanEntity> applyLoan) {
		this.value = value;
		this.status = status;
		this.bankAccount = bankAccount;
		this.cEntity = cEntity;
		this.transactionEntities = transactionEntities;
		this.applyLoan = applyLoan;
	}

	public Response() {
		
	}

}
