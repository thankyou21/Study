package com.cg.mpa.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="purchasedetails_157980")
public class PurchaseDetails 
{
	@Id
	@Column(name="purchase_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	@SequenceGenerator(name="seq", sequenceName="purchaseIdSeq", allocationSize=1)
	private Integer purchaseId;

	@NotEmpty(message="Name is mandatory.")
	@Pattern(regexp="[A-Za-z]{3,20}", message="Name should contain a minimum of 3 and maximum of 20 letters")
	@Column(name="customer_name")
	private String custName;
	
	@Email(message="Enter a vaild E-mail ID")
	@Column(name="mail_id")
	private String mailId;
	
	@NotEmpty(message="Phone No. is mandatory.")
	@Pattern(regexp="[0-9]{10}", message="Phone No. should contain 10digits")
	@Column(name="phone_no")
	private String phoneNo;
	
	@Pattern(regexp="[0-9]{2}-[A-Za-z]{3}-[0-9]{4}", message="Enter a vaild Date")
	@Column(name="purchase_date")
	private String purchaseDate;
	
	@Column(name="mobile_id")
	private Integer mobileid;
	
	
	public Integer getMobileid() {
		return mobileid;
	}

	public void setMobileid(Integer mobileid) {
		this.mobileid = mobileid;
	}

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
}
