package com.mwe.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@FeignClient(value = "mwe-service-client", fallback = FacebookServiceImpl.class)
public interface IFacebookService {

	@GetMapping("/facebook")
	public String facebook();
	
	@GetMapping("/connect/facebook")
	public String redirectFacebookPage();
	
	@RequestMapping(value="/connect/facebook", method=RequestMethod.POST)
	public String connectFacebook(@RequestParam(value="scope") String scope);
	
	@GetMapping("/connect/facebookHello")
	public String helloFacebook();
}
