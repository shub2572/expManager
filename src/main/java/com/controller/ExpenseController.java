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

import com.bean.AccountBean;
import com.bean.CategoryBean;
import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.AccountDao;
import com.dao.CategoryDao;
import com.dao.ExpenseDao;
import com.dao.UserDao;

@Controller
public class ExpenseController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ExpenseDao expenseDao;
	
	@Autowired
	AccountDao accDao;
	
	@Autowired
	CategoryDao catDao;
	
	
	
	@GetMapping("/addexpense")
	public String addExpense(Model model,HttpSession session,ExpenseBean expBean) {
		UserBean user = (UserBean) session.getAttribute("user");
		List<CategoryBean> categories = catDao.getCategoriesByUserId(user.getUserId());
		List<AccountBean> accounts = accDao.getAccountsByUserId(user.getUserId());
		model.addAttribute("categories",categories);
		model.addAttribute("accounts",accounts);
		model.addAttribute("expBean",expBean);
		return "AddExpense";
	}
	
	@PostMapping("/addexpenses")
	public String addExpenseToUser(@ModelAttribute("expBean") @Valid ExpenseBean expBean,BindingResult result,HttpSession session,Model model) {
		System.out.println(result);
		if(result.hasErrors()) {
			UserBean user = (UserBean) session.getAttribute("user");
			List<AccountBean> accounts = accDao.getAccountsByUserId(user.getUserId());
			List<CategoryBean> categories = catDao.getCategoriesByUserId(user.getUserId());
			model.addAttribute("accounts",accounts);
			model.addAttribute("categories",categories);
			model.addAttribute("expBean",expBean);
			return "AddExpense";
		}
		else {
			UserBean user = (UserBean) session.getAttribute("user");
			int userId = user.getUserId();
			expBean.setUserId(userId);
			int accId = expBean.getAccId();
			AccountBean account = expenseDao.getBalance(userId,accId);
			int balance = account.getAccBalance() - expBean.getExpAmount();
			System.out.println("Balance :"+balance);
			expenseDao.addExpense(expBean,balance);
			return "Home";
		}
		
		
	}
	
	@GetMapping("/listexpense")
	public String listExpenses(HttpSession session,Model model) {
		UserBean user = (UserBean) session.getAttribute("user");
		List<ExpenseBean> expenses =  expenseDao.getExpensesByUserId(user.getUserId());
		model.addAttribute("expenses",expenses);
		return "ListExpenses";
	}
}
