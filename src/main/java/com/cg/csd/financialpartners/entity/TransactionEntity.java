package com.cg.csd.financialpartners.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Transaction_id")
	private Long id;
	@Column(name = "Customer_Id")
	private Long customerId;
	@Column(name = "To_Account")
	private String toAcc;
	@Column(name = "From_Account")
	private String fromAcc;
	@Column(name = "Transaction_Type")
	private String tType;
	@Column(name = "Transaction_Date")
	private LocalDate tDate;
	@Column(name = "Transaction_Time")
	private LocalTime tTime;
	@Column(name = "Transaction_Amount")
	private Long tAmount;

	public TransactionEntity() {
		super();
	}

	public TransactionEntity(Long id, Long customerId, String toAcc, String fromAcc, String tType, LocalDate tDate,
			LocalTime tTime, Long tAmount) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.toAcc = toAcc;
		this.fromAcc = fromAcc;
		this.tType = tType;
		this.tDate = tDate;
		this.tTime = tTime;
		this.tAmount = tAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getToAcc() {
		return toAcc;
	}

	public void setToAcc(String toAcc) {
		this.toAcc = toAcc;
	}

	public String getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(String fromAcc) {
		this.fromAcc = fromAcc;
	}

	public String gettType() {
		return tType;
	}

	public void settType(String tType) {
		this.tType = tType;
	}

	public LocalDate gettDate() {
		return tDate;
	}

	public void settDate(LocalDate tDate) {
		this.tDate = tDate;
	}

	public LocalTime gettTime() {
		return tTime;
	}

	public void settTime(LocalTime tTime) {
		this.tTime = tTime;
	}

	public Long gettAmount() {
		return tAmount;
	}

	public void settAmount(Long tAmount) {
		this.tAmount = tAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((fromAcc == null) ? 0 : fromAcc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tAmount == null) ? 0 : tAmount.hashCode());
		result = prime * result + ((tDate == null) ? 0 : tDate.hashCode());
		result = prime * result + ((tTime == null) ? 0 : tTime.hashCode());
		result = prime * result + ((tType == null) ? 0 : tType.hashCode());
		result = prime * result + ((toAcc == null) ? 0 : toAcc.hashCode());
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
		TransactionEntity other = (TransactionEntity) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (fromAcc == null) {
			if (other.fromAcc != null)
				return false;
		} else if (!fromAcc.equals(other.fromAcc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tAmount == null) {
			if (other.tAmount != null)
				return false;
		} else if (!tAmount.equals(other.tAmount))
			return false;
		if (tDate == null) {
			if (other.tDate != null)
				return false;
		} else if (!tDate.equals(other.tDate))
			return false;
		if (tTime == null) {
			if (other.tTime != null)
				return false;
		} else if (!tTime.equals(other.tTime))
			return false;
		if (tType == null) {
			if (other.tType != null)
				return false;
		} else if (!tType.equals(other.tType))
			return false;
		if (toAcc == null) {
			if (other.toAcc != null)
				return false;
		} else if (!toAcc.equals(other.toAcc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransactionEntity [id=" + id + ", customerId=" + customerId + ", toAcc=" + toAcc + ", fromAcc="
				+ fromAcc + ", tType=" + tType + ", tDate=" + tDate + ", tTime=" + tTime + ", tAmount=" + tAmount + "]";
	}

}