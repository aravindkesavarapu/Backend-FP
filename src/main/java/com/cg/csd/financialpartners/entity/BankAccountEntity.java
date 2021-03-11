package com.cg.csd.financialpartners.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "BankAccount")
public class BankAccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "Account_No")
	private String accNo;
	@Column(name = "Customer_Id")
	private Long customerId;
	@Column(name = "Account_Balance")
	private double accBal;
	@Column(name = "Ifsc_Code")
	private String ifsc;
	@Column(name = "Doc_Type")
	private String docType;
	@Column(name = "Doc_No")
	private Long docNo;
	@Column(name = "Cibil")
	private Double cibil; 
	@Column(name = "org_Name")
	private String orgName;
	@Column(name = "account_Type")
	private String accountType;
	@Column(name = "customer_name")
	private String customerName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public double getAccBal() {
		return accBal;
	}
	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public Long getDocNo() {
		return docNo;
	}
	public void setDocNo(Long docNo) {
		this.docNo = docNo;
	}
	public Double getCibil() {
		return cibil;
	}
	public void setCibil(Double cibil) {
		this.cibil = cibil;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public BankAccountEntity(Long id, String accNo, Long customerId, double accBal, String ifsc, String docType,
			Long docNo, Double cibil, String orgName, String accountType, String customerName) {
		super();
		this.id = id;
		this.accNo = accNo;
		this.customerId = customerId;
		this.accBal = accBal;
		this.ifsc = ifsc;
		this.docType = docType;
		this.docNo = docNo;
		this.cibil = cibil;
		this.orgName = orgName;
		this.accountType = accountType;
		this.customerName = customerName;
	}
	public BankAccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accBal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accNo == null) ? 0 : accNo.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((cibil == null) ? 0 : cibil.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((docNo == null) ? 0 : docNo.hashCode());
		result = prime * result + ((docType == null) ? 0 : docType.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ifsc == null) ? 0 : ifsc.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccountEntity other = (BankAccountEntity) obj;
		if (Double.doubleToLongBits(accBal) != Double.doubleToLongBits(other.accBal))
			return false;
		if (accNo == null) {
			if (other.accNo != null)
				return false;
		} else if (!accNo.equals(other.accNo))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (cibil == null) {
			if (other.cibil != null)
				return false;
		} else if (!cibil.equals(other.cibil))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (docNo == null) {
			if (other.docNo != null)
				return false;
		} else if (!docNo.equals(other.docNo))
			return false;
		if (docType == null) {
			if (other.docType != null)
				return false;
		} else if (!docType.equals(other.docType))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ifsc == null) {
			if (other.ifsc != null)
				return false;
		} else if (!ifsc.equals(other.ifsc))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		return true;
	}
	
	
}