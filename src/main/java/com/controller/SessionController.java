package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;
	
	@GetMapping("/home")
	public String Home() {
		return "Home";
	}
	
	@GetMapping("/signup")
	public String signUp(Model model) {
		UserBean user = new UserBean();
		model.addAttribute("user",user);
		return "Signup";
	}
	
	@PostMapping("/signup")
	public String addUser(@ModelAttribute("user") @Valid UserBean user,BindingResult result,Model model) {
		System.out.println("Save User called");
		if(result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("user",user);
			return "Signup";
		}
		else {
			
			if(userDao.getUserByEmail(user.getEmail()) == null) {
				user.setUserType("customer");
				user.setActive(true);
				userDao.addUser(user);
				model.addAttribute("successSignup","Sign Up successfully");
				return "Login";
			}else {
				model.addAttribute("user",user);
				model.addAttribute("errorSignup","Email already exists! Try another Email");
				return "Signup";
			}
		}
	}
		
	@GetMapping("/login")
	public String login(Model model) {
		LoginBean user = new LoginBean();
		model.addAttribute("user",user);
		return "Login";
	}
	@PostMapping("/authenticate")
	public String authenticate(@ModelAttribute("user") @Valid LoginBean loginBean,BindingResult result,Model model,HttpSession session) {
		
		if(result.hasErrors()) {
			model.addAttribute("user",loginBean);
			return "Login";
		}
		else {
			UserBean user = userDao.authenticateUser(loginBean);
			if(user != null) {
				if(user.getUserType().equals("customer")) {
					session.setAttribute("user", user);
					model.addAttribute("successLogin","Login Successfully");
					return "Home";
				}
				else if(user.getUserType().equals("admin")) {
					session.setAttribute("user", user);
					model.addAttribute("successLogin","Login Successfully");
					return "Dashboard";
				}
				else {
					model.addAttribute("errorLogin","Please contact Admin");
					return "Login";
				}
				
			}else {
				model.addAttribute("user",loginBean);
				model.addAttribute("errorLogin","Invalid Email or Password !");
				return "Login";
			}		
		}
		
		
	}
	
	@GetMapping("/logout")
	public String logoutUser() {
		return "redirect:/login";
	}
	
}
