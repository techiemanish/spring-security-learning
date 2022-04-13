package com.learn.springbootsecuitylearn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

	@GetMapping("/signin")
	public String signin() {
		return "login.html";
	}

}
