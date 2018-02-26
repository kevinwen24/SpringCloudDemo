package com.mwe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mwe.vo.Msg;

@RestController
public class TestController {

	@GetMapping("/test")
	public String setValue(HttpSession session) {
		session.setAttribute("B", "B");
		return "B";
	}
	
}
