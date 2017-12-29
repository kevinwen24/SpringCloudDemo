package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.entity.User;

@Controller
public class LoginController {
		
	@GetMapping("/login")
	public String loginPage () {
		return "login/login";
	}
	
	@GetMapping("/dashboard")
	public String dashboardPage () {
		return "dashboard";
	}
	
	@PostMapping("/login")
	public ModelAndView login (@Valid User user, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/redirect");
		if ("kevin".equals(user.getUserName()) && "1234".equals(user.getPassword())) {
			HttpSession session = request.getSession();
			user.setPassword("");
			session.setAttribute("user", user);
			System.out.println(session.getAttribute("user"));
		}
		modelAndView.addObject("redirect", "/api-b/dashboard");
		return modelAndView;
	}
}
