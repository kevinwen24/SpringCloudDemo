package com.mwe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/hello")
    public String sayHello(){
    	return "redirect:/api-b/index";
    }
	
	@GetMapping("/yes")
	@ResponseBody
    public String yes(){
    	return "yes";
    }
}
