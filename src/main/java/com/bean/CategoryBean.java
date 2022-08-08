package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class CategoryBean {

	Integer catId;
	@NotBlank(message = "Please Enter Category Name")
	String catName;
	
	Integer subCatId;
	@NotBlank(message = "Please Enter Sub Category Name")
	String subCatName;
	Integer userId;
	
	public Integer getCatId() {
		return catId;
	}
	public void setCatId(Integer catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
	public Integer getSubCatId() {
		return subCatId;
	}
	public void setSubCatId(Integer subCatId) {
		this.subCatId = subCatId;
	}
	public String getSubCatName() {
		return subCatName;
	}
	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
