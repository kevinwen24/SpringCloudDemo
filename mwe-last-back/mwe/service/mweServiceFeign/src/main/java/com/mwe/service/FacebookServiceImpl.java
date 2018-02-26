package com.mwe.service;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.RedirectView;

@Component
public class FacebookServiceImpl implements IFacebookService{

	@Override
	public String facebook() {
		return "Sorry";
	}

	@Override
	public String redirectFacebookPage() {
		return "Sorry";
	}

	@Override
	public String connectFacebook(String scope) {
		return "Sorry";
	}

	@Override
	public String helloFacebook() {
		return "Sorry";
	}
}
