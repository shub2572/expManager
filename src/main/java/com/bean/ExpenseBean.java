package com.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class ExpenseBean {

	Integer expId;
	@NotBlank(message = "Please Enter Expense Name")
	String expName;
	@NotBlank(message = "Please Enter Expense Location")
	String expLocation;
	@NotNull(message = "Please Select Expense Category")
	Integer expCat;
	@NotNull(message = "Please Select Expense Sub Category")
	Integer expSubCat;
	@NotBlank(message = "Please Select Account Type")
	String accType;
	@NotNull(message = "Please Select Account")
	Integer accId;
	@NotNull(message = "Please Enter Expense Amount") @Min(message="Please Enter Valid Expense Amount",value = 1)
	Integer expAmount;
	
	String accName;
	Long accNumber;
	Integer accBalance;
	String date;
	String time;
	Integer userId;
	String catName;
	String subCatName;
	
	public Integer getExpId() {
		return expId;
	}
	public void setExpId(Integer expId) {
		this.expId = expId;
	}
	public String getExpName() {
		return expName;
	}
	public void setExpName(String expName) {
		this.expName = expName;
	}
	public String getExpLocation() {
		return expLocation;
	}
	public void setExpLocation(String expLocation) {
		this.expLocation = expLocation;
	}

	public Integer getExpCat() {
		return expCat;
	}
	public void setExpCat(Integer expCat) {
		this.expCat = expCat;
	}
	
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public Integer getExpSubCat() {
		return expSubCat;
	}
	public void setExpSubCat(Integer expSubCat) {
		this.expSubCat = expSubCat;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public Long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(Long accNumber) {
		this.accNumber = accNumber;
	}
	public Integer getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(Integer accBalance) {
		this.accBalance = accBalance;
	}
	public Integer getExpAmount() {
		return expAmount;
	}
	public void setExpAmount(Integer expAmount) {
		this.expAmount = expAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}
	public String getSubCatName() {
		return subCatName;
	}
	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}
	
	
}
