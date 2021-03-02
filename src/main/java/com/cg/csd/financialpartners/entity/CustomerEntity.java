package com.cg.csd.financialpartners.entity;
import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "CUSTOMER_ID")
	private long customerId;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "CUSTOMER_GENDER")
	private String customerGender;

	@Column(name = "CUSTOMER_ADDRESS")
	private String customerAddress;

	@Column(name = "CUSTOMER_DOB")
	private String customerDOB;

	@Column(name = "CUSTOMER_MOBILENO")
	private String customerMobileNo;

	@Column(name = "CUSTOMER_EMAILID")
	private String customerEmailId;

	@Column(name = "CUSTOMER_TYPE")
	private String customerType;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PANCARD_NO")
	private String pancardNo;
	

	
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(String customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerMobileNo() {
		return customerMobileNo;
	}

	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPancardNo() {
		return pancardNo;
	}

	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}

	public CustomerEntity(long customerId, String customerName, String customerGender, String customerAddress,
			String customerDOB, String customerMobileNo, String customerEmailId, String customerType, String password,
			String pancardno) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGender = customerGender;
		this.customerAddress = customerAddress;
		this.customerDOB = customerDOB;
		this.customerMobileNo = customerMobileNo;
		this.customerEmailId = customerEmailId;
		this.customerType = customerType;
		this.password = password;
		this.pancardNo = pancardno;
	}

	public CustomerEntity() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result + ((customerDOB == null) ? 0 : customerDOB.hashCode());
		result = prime * result + ((customerEmailId == null) ? 0 : customerEmailId.hashCode());
		result = prime * result + ((customerGender == null) ? 0 : customerGender.hashCode());
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		result = prime * result + ((customerMobileNo == null) ? 0 : customerMobileNo.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerType == null) ? 0 : customerType.hashCode());
		result = prime * result + ((pancardNo == null) ? 0 : pancardNo.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		CustomerEntity other = (CustomerEntity) obj;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerDOB == null) {
			if (other.customerDOB != null)
				return false;
		} else if (!customerDOB.equals(other.customerDOB))
			return false;
		if (customerEmailId == null) {
			if (other.customerEmailId != null)
				return false;
		} else if (!customerEmailId.equals(other.customerEmailId))
			return false;
		if (customerGender == null) {
			if (other.customerGender != null)
				return false;
		} else if (!customerGender.equals(other.customerGender))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerMobileNo == null) {
			if (other.customerMobileNo != null)
				return false;
		} else if (!customerMobileNo.equals(other.customerMobileNo))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerType == null) {
			if (other.customerType != null)
				return false;
		} else if (!customerType.equals(other.customerType))
			return false;
		if (pancardNo == null) {
			if (other.pancardNo != null)
				return false;
		} else if (!pancardNo.equals(other.pancardNo))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", customerName=" + customerName + ", customerGender="
				+ customerGender + ", customerAddress=" + customerAddress + ", customerDOB=" + customerDOB
				+ ", customerMobileNo=" + customerMobileNo + ", customerEmailId=" + customerEmailId + ", customerType="
				+ customerType + ", password=" + password + ", pancardno=" + pancardNo + "]";
	}	
}