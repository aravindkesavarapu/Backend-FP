package com.cg.csd.financialpartners.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Loan")
public class ApplyLoanEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loanId;
	
	@Column(name ="cAccNumber")
	private String cAccNumber;
	
	@Column(name ="loanAmmount")
	private double ammount;
	
	@Column(name ="cibil")
	private Long cibil;
	
	@Column(name ="interestRate")
	private double interestRate;
	
	@Column(name ="duration")
	private String duration;
	
	@Column(name ="emi")
	private double emi;
	
	@Column(name ="purpose")
	private String purpose;

	@Column(name ="loanStatus")
	private String status;
	
	@Column(name ="startDate")
	private LocalDate startDate;
	
	@Column(name ="endDate")
	private LocalDate endDate;

	@Column(name ="custId")
	private Long custId;

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public String getcAccNumber() {
		return cAccNumber;
	}

	public void setcAccNumber(String cAccNumber) {
		this.cAccNumber = cAccNumber;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public Long getCibil() {
		return cibil;
	}

	public void setCibil(Long cibil) {
		this.cibil = cibil;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Long getcustId() {
		return custId;
	}

	public void setcustId(Long custId) {
		this.custId = custId;
	}

	public ApplyLoanEntity() {
		super();
	}

	public ApplyLoanEntity(Long loanId, String cAccNumber, double ammount, Long cibil, double interestRate,
			String duration, double emi, String purpose, String status, LocalDate startDate, LocalDate endDate,
			Long custId) {
		super();
		this.loanId = loanId;
		this.cAccNumber = cAccNumber;
		this.ammount = ammount;
		this.cibil = cibil;
		this.interestRate = interestRate;
		this.duration = duration;
		this.emi = emi;
		this.purpose = purpose;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.custId = custId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(ammount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cAccNumber == null) ? 0 : cAccNumber.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((cibil == null) ? 0 : cibil.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		temp = Double.doubleToLongBits(emi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		temp = Double.doubleToLongBits(interestRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanId == null) ? 0 : loanId.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ApplyLoanEntity other = (ApplyLoanEntity) obj;
		if (Double.doubleToLongBits(ammount) != Double.doubleToLongBits(other.ammount))
			return false;
		if (cAccNumber == null) {
			if (other.cAccNumber != null)
				return false;
		} else if (!cAccNumber.equals(other.cAccNumber))
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (cibil == null) {
			if (other.cibil != null)
				return false;
		} else if (!cibil.equals(other.cibil))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (Double.doubleToLongBits(emi) != Double.doubleToLongBits(other.emi))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (Double.doubleToLongBits(interestRate) != Double.doubleToLongBits(other.interestRate))
			return false;
		if (loanId == null) {
			if (other.loanId != null)
				return false;
		} else if (!loanId.equals(other.loanId))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ApplyLoanEntity [loanId=" + loanId + ", cAccNumber=" + cAccNumber + ", ammount=" + ammount + ", cibil="
				+ cibil + ", interestRate=" + interestRate + ", duration=" + duration + ", emi=" + emi + ", purpose="
				+ purpose + ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate + ", custId=" + custId
				+ "]";
	}
	
}
