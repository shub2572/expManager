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
import com.bean.UserBean;
import com.dao.AccountDao;

@Controller
public class AccountController {
	@Autowired
	AccountDao accDao;
	
	
	
	@GetMapping("/addaccount")
	public String addAccount(Model model) {
		AccountBean accountBean = new AccountBean();
		model.addAttribute("account",accountBean);
		return "AddAccount";
	}
	
	@PostMapping("/addaccount")
	public String addAccountToUser(@ModelAttribute("account") @Valid AccountBean accountBean,BindingResult result,Model model,HttpSession session){
		System.out.println("this called");
		if(result.hasErrors()) {
			model.addAttribute("account",accountBean);
			return "AddAccount";
		}
		else {
			UserBean u = (UserBean) session.getAttribute("user");
			accountBean.setUserId(u.getUserId());
			accDao.addAccountToUser(accountBean);
			model.addAttribute("account","Account Added Successfully");
			return "Home";
		}
	}
	
	@GetMapping("/listaccount")
	public String listAccounts(HttpSession session,Model model) {
		UserBean user = (UserBean) session.getAttribute("user");
		List<AccountBean> accounts =  accDao.getAccountsByUserId(user.getUserId());
		System.out.println(accounts.get(0).getAccname());
		model.addAttribute("accounts",accounts);
		return "ListAccounts";
	}
}
