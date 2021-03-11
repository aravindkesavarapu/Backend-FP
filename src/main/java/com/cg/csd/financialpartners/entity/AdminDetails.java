package com.cg.csd.financialpartners.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_details")
public class AdminDetails {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "email_id")
	private String emailId;
	@Column(name = "mobile_no")
	private Long mobileNo;
	@Column(name = "password")
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminDetails [id=" + id + ", userName=" + userName + ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", password=" + password + "]";
	}
	public AdminDetails(Long id, String userName, String emailId, Long mobileNo, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.password = password;
	}
	public AdminDetails() {
		super();
	}
	
}
