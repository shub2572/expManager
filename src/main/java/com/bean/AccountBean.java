package com.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class AccountBean {

	Integer accId;
	@NotBlank(message = "Please Enter Account Name")
	String accname;
	@NotNull(message = "Please Enter Account Number")
	Long accnumber;
	@NotBlank(message = "Please Enter Account Type")
	String acctype;
	@NotNull(message = "Please Enter Account Balance") @Min(message="Please Enter Valid Account Balance",value = 1)
	Integer accbalance;
	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}
	public String getAccname() {
		return accname;
	}
	public void setAccname(String accname) {
		this.accname = accname;
	}
	public Long getAccnumber() {
		return accnumber;
	}
	public void setAccnumber(Long accnumber) {
		this.accnumber = accnumber;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public Integer getAccbalance() {
		return accbalance;
	}
	public void setAccbalance(Integer accbalance) {
		this.accbalance = accbalance;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	Integer userId;
	public Integer getAccBalance() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
