package com.mwe.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mwe-service-client", fallback = TwitterServiceImpl.class)
public interface ITwitterService {

	@GetMapping("/twitter")
	public String twitter();
	
	@GetMapping("/connect/twitter")
	public String redirectTwitterPage();
	
	@RequestMapping(value="/connect/twitter", method=RequestMethod.POST)
	public String connectTwitter();
	
	@GetMapping("/connect/twitterHello")
	public String helloTwitter();

	@RequestMapping(value="/twitter/RedirectView", method=RequestMethod.POST)
	public String testTwitter();
}
