package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AccountBean;
import com.bean.UserBean;
import com.dao.AccountDao;

@RestController
public class SubAccountsController {

	@Autowired
	AccountDao accountDao;
	
	@GetMapping("/accnames")
	public List<AccountBean> getAllSubCategories(@RequestParam("accType") String accType,HttpSession session){
		
		UserBean user = (UserBean) session.getAttribute("user");
		List<AccountBean> accounts = accountDao.getaccountsByaccType(accType,user.getUserId());
		return accounts;
		
	}
}
