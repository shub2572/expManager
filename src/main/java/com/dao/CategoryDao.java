package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;

@Repository
public class CategoryDao {

	@Autowired
	JdbcTemplate stmt;
	
	
	
	public List<CategoryBean> getCategoriesByUserId(int userId) {
		
		List<CategoryBean> category = stmt.query("select * from category where userid = ? or userid = ?",new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class),new Object[] {userId,1});
		return category;
	}

	public List<CategoryBean> getSubCategoriesByCatId(int catId) {
		
		List<CategoryBean> category = stmt.query("select * from subcategory where categoryid = ?",new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class),new Object[] {catId});
		return category;
	}


	public void addCategoryToUser(CategoryBean catBean) {

		stmt.update("insert into category (catname,userid) values(?,?)",catBean.getCatName(),catBean.getUserId());
	}



	public void addSubCategoryToUser(CategoryBean catBean) {
		stmt.update("insert into subcategory (subcatname,categoryid) values(?,?)",catBean.getSubCatName(),catBean.getCatId());		
	}



	public CategoryBean getCategoryIdByUser(String catName, Integer userId) {
		
		CategoryBean category = stmt.queryForObject("select catid from category where catname = ? and userid = ?",new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class),new Object[] {catName,userId});
		return category;
	}

	public CategoryBean getCategoryIdByCatName(String catName, Integer userId) {
		
		CategoryBean category = stmt.queryForObject("select * from category where catname = ? and userid = ? ",new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class),new Object[] {catName,userId});
		return category;
	}
}
