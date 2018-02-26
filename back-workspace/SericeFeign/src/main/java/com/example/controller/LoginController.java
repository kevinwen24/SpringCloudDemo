package com.example.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.example.entity.User;

@Controller
public class LoginController {
		
	@GetMapping("/login")
	public String loginPage (HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.err.println("getRequestedSessionId="+request.getRequestedSessionId());
		System.err.println("sessionId="+session.getId());
		return "login/login";
	}
	
	@GetMapping("/dashboard")
	public String dashboardPage () {
		return "dashboard";
	}
	
	@PostMapping("/login")
	public String login (@Valid User user, 
			HttpServletRequest request, 
			HttpServletResponse response,
			Model model) throws IOException {
		HttpSession session = request.getSession();
		System.err.println("sessionId="+request.getRequestedSessionId());
		ModelAndView modelAndView = new ModelAndView("redirect");
		if ("kevin".equals(user.getUserName()) && "1234".equals(user.getPassword())) {
			user.setPassword("");
			session.setAttribute("user", user);
			System.err.println(session.getAttribute("test"));
			System.err.println(session.getAttribute("user"));
		}
		/*response.getWriter().write("<script type='text/javascript'>window.location.href='/api-b/dashboard'</script>");
		response.flushBuffer();*/
		model.addAttribute("redirect", "/api-b/dashboard");
		return "redirect";
	}
	
	@GetMapping("/uid")
	@ResponseBody
	public	String uid(HttpSession session) {
		System.out.println(session.getAttribute("user"));
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
		uid = UUID.randomUUID();
		}
		System.out.println(uid);
		session.setAttribute("uid", uid);
		return session.getId();
	}
}
