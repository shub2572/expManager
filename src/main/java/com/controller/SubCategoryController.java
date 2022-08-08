package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CategoryBean;
import com.dao.CategoryDao;

@RestController
public class SubCategoryController {

	@Autowired
	CategoryDao catDao;
	
	@GetMapping("/subcategories")
	public List<CategoryBean> getAllSubCategories(@RequestParam("catId") int catId){
		
		List<CategoryBean> subcategory = catDao.getSubCategoriesByCatId(catId);
		return subcategory;
		
	}
}
