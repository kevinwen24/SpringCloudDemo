package com.mwe.service;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.RedirectView;

@Component
public class TwitterServiceImpl implements ITwitterService{

	@Override
	public String twitter() {
		return "sorry";
	}

	@Override
	public String redirectTwitterPage() {
		return "sorry";
	}

	@Override
	public String connectTwitter() {
		return "sorry";
	}

	@Override
	public String helloTwitter() {
		return "sorry";
	}

	@Override
	public String testTwitter() {
		return "sorry, test in twitter";
	}

}
