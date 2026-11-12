package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String form() {
		return "forward:/login.html";
	}

	@PostMapping("/login")
	public String submit(@RequestParam(defaultValue = "") String email,
			@RequestParam(defaultValue = "") String password) {
		if (!StringUtils.hasText(email) || !StringUtils.hasText(password)) {
			return "redirect:/login?error=missing";
		}
		return "redirect:/login?sent=1";
	}

}
