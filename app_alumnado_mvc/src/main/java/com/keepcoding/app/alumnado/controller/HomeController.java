package com.keepcoding.app.alumnado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.keepcoding.app.alumnado.objects.LoginInfo;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model modelo) {
		modelo.addAttribute("loginInfo", new LoginInfo());
		return "loginUser";
	}


}
