package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController  implements org.springframework.boot.web.servlet.error.ErrorController{

@RequestMapping("/error")
public String Error() {
	
	return "404";
}

@GetMapping("/error")
public String errors() {
	
	return "404";
}
}
