package com.mwe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mwe.service.IFacebookService;

@RestController
public class FacebookController {

	@Autowired
	private IFacebookService facebookServiceImpl;
	
	@GetMapping("/facebook")
	public String Facebook() {
		return facebookServiceImpl.facebook();
	}
	
	@GetMapping("/connect/facebook")
	public String redirectConnectFacebookPage() {
		return facebookServiceImpl.redirectFacebookPage();
	}
	
	@PostMapping("/connect/facebook")
	public String connectFacebook(@RequestParam(value="scope") String scope) {
		String connectFacebook = facebookServiceImpl.connectFacebook(scope);
		System.out.println(connectFacebook);
		return connectFacebook;
	}
	
	@GetMapping("/connect/facebookHello")
	public String helloFacebook() {
		return facebookServiceImpl.helloFacebook();
	}
}
