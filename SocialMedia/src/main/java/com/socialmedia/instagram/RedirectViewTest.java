package com.socialmedia.instagram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectViewTest {

	@GetMapping("/RedirectView")
	public RedirectView a() {
		return new RedirectView("http://www.baidu.com");
	}
}
