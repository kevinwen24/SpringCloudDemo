package com.mwe.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mwe.entity.SysUser;
import com.mwe.service.SysUserService;

@Controller
public class loginController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@GetMapping("/")
    public String index( HttpSession session) {
        return "redirect:/api-b/index";
    }
	
	@GetMapping("/login")
	public String loginPage(@RequestParam(value = "go",defaultValue = "") String goPage, Model model, HttpSession session) {
		model.addAttribute("uri", goPage);
		return "login";
	}
	
	@GetMapping("/accessDeny")
    public String accessDeny() {
        return "accessDeny";
    }
	
	@PostMapping("/login")
    public String login(@RequestParam(value = "username") String userName,
    					@RequestParam(value = "password") String password,
    					@RequestParam(value = "uri") String uri,
    					@RequestParam(value = "queryString") String queryString,
    					HttpServletResponse response,
    					HttpSession session,
    					Model model) {
		String redirectSuccessPage = "redirect:/api-b/index";
		if (StringUtils.isNotEmpty(uri)) {
			redirectSuccessPage = "redirect:" + uri;
			
			if (StringUtils.isNotEmpty(queryString)) {
				redirectSuccessPage = "redirect:" + uri + "?" + queryString.substring(1);
			}
		}
		
		SysUser user = sysUserService.findUserByUsername(userName);
		if (user != null && user.getPassword() != null && user.getPassword().equals(password)) {
			user.setPassword("");
			session.setAttribute("user", user);
			
			if (session.getAttribute("goPage") != null) {
				redirectSuccessPage = String.valueOf(session.getAttribute("goPage"));
			}
			return redirectSuccessPage;
	    } else {
	    	session.setAttribute("goPage", redirectSuccessPage);
	    	return "redirect:/login?error";
	    }
    }
	
	@GetMapping("/logout")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "redirect:/login?logout";
	}
}
