package com.cg.csd.financialpartners.entity;

public class UpdatePasword {
	private String customerMobileNo;
	private String password;
	private String newpassword;


	
	public UpdatePasword(String customerMobileNo, String password, String newpassword) {
		super();
		this.customerMobileNo = customerMobileNo;
		this.password = password;
		this.newpassword = newpassword;
	}

	public String getCustomerMobileNo() {
		return customerMobileNo;
	}

	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public UpdatePasword() {
		// TODO Auto-generated constructor stub
	}

}
