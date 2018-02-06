package com.springboot.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.web.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
	LoginService loginService;
	@RequestMapping(value = "/login", method= RequestMethod.GET)
   	public String loginMessage(ModelMap model) {
		//System.out.println("Name--"+name); 
		//model.put("name", name);
		return "login";
		
		
	}
	
	@RequestMapping(value = "/login", method= RequestMethod.POST)
   	public String showWelcome(ModelMap model, @RequestParam String name, @RequestParam String password) {
		//System.out.println("Name--"+name); 
		if (! loginService.isValidUser(name,password)) {
			model.put("errMsg","Invalid Credentails");
			return "login"; 
		} else {		
			model.put("name", name);
			//model.put("password", password);
			return "welcome";

		}
		
	}
	}
