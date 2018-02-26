package com.mwe.controller;

import javax.inject.Inject;

import org.springframework.social.linkedin.api.*;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/linkedin")
public class LinkedinController {

	/*private final LinkedIn linkedin;
	
	private ConnectionRepository connectionRepository;
	
    @Inject
    public LinkedinController(LinkedIn linkedin, ConnectionRepository connectionRepository) {
        this.linkedin = linkedin;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String helloLinkedin(Model model) {
        if (connectionRepository.findPrimaryConnection(LinkedIn.class) == null) {
             //return "redirect:/api-b/connect/linkedin";
             model.addAttribute("redirectUrl", "/api-b/connect/linkedin");
             return "connect/redirect"; 
        }
        
        LinkedInProfile userProfile = linkedin.profileOperations().getUserProfile();        
        model.addAttribute("linkedinProfile", userProfile);
        return "connect/linkedinHello";
    }*/
}
