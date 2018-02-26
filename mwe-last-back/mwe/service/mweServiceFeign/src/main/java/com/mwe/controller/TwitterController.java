package com.mwe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mwe.service.ITwitterService;

@RestController
public class TwitterController {

	@Autowired
	private ITwitterService twitterServiceImpl;
	
	@GetMapping("/twitter")
	public String Twitter() {
		return twitterServiceImpl.twitter();
	}
	
	@GetMapping("/connect/twitter")
	public String redirectConnectTwitterPage() {
		return twitterServiceImpl.redirectTwitterPage();
	}
	
	@PostMapping("/connect/twitter")
	public String connectTwitter() {
		String connectTwitter = twitterServiceImpl.connectTwitter();
		System.out.println(connectTwitter);
		return connectTwitter;
	}
	
	@GetMapping("/connect/twitterHello")
	public String helloTwitter() {
		return twitterServiceImpl.helloTwitter();
	}
	
	@PostMapping("/twitter/RedirectView")
	public String a() {
		String aString = twitterServiceImpl.testTwitter();
		System.out.println(aString);
		return aString;
	}
}
