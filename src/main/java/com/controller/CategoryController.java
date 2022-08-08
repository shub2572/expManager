package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CategoryBean;
import com.bean.UserBean;
import com.dao.CategoryDao;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao catDao;
	
	@GetMapping("/addcategory")
	public String addCategory(CategoryBean catBean,Model model) {
		model.addAttribute("catBean",catBean);
		return "AddCategory";
	}
	
	@PostMapping("/addcategory")
	public String addCategoryToUser(@ModelAttribute("catBean") @Valid CategoryBean catBean,BindingResult result,HttpSession session,Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("catBean",catBean);
			return "AddCategory";
		}
		else {
		
			UserBean user = (UserBean) session.getAttribute("user");
			catBean.setUserId(user.getUserId());
			catDao.addCategoryToUser(catBean);
			
			CategoryBean category = catDao.getCategoryIdByUser(catBean.getCatName(),user.getUserId());
			System.out.println("user ID => "+user.getUserId());
			catBean.setCatId(category.getCatId());		System.out.println("Cat ID => "+category.getCatId());
			catDao.addSubCategoryToUser(catBean);
			
			if(user.getUserType().equals("admin")) {
				return "Dashboard";
			}
			else {
				return "Home";
			}
		}
		
	}
	
	@GetMapping("/addsubcategory")
	public String addSubCat(CategoryBean catBean,Model model,HttpSession session) {
		UserBean user = (UserBean) session.getAttribute("user");
		List<CategoryBean> categories = catDao.getCategoriesByUserId(user.getUserId());
		model.addAttribute("categories",categories);
		model.addAttribute("catid",categories);
		model.addAttribute("catBean",catBean);
		return "AddSubCategory";
	}
	
	@PostMapping("/addsubcategory")
	public String addSubCategory(CategoryBean catBean,Model model,HttpSession session) {
		
		catBean.setCatId(catBean.getCatId());
		catDao.addSubCategoryToUser(catBean);
		
		UserBean user = (UserBean) session.getAttribute("user");
		if(user.getUserType().equals("admin")) {
			return "Dashboard";
		}
		else {
			return "Home";
		}
	}
	
	@GetMapping("/listcategory")
	public String listCategories(Model model,HttpSession session) {
		UserBean user = (UserBean) session.getAttribute("user");
		System.out.println("U I D :"+user.getUserId());
		List<CategoryBean> category = catDao.getCategoriesByUserId(user.getUserId());
		model.addAttribute("category",category);
		return "ListCategory";
	}
}
