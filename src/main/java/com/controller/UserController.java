package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	
	@GetMapping("/listUsers")
	public String listUsers(Model model) {
		List<UserBean> users = userDao.getAllUsers();
		model.addAttribute("users",users);
		return "ListUsers";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int userId) {
		
		userDao.deleteUser(userId);
		return "redirect:/listUsers";
	}
	
	@GetMapping("/editUser")
	public String editUser(@RequestParam("userId") int userId,Model model) {
		UserBean user = userDao.getUserByUserId(userId);
		model.addAttribute("user",user);
		return "EditUser";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(UserBean user) {
		userDao.updateUser(user);
		return "redirect:/listUsers";
	}
}
