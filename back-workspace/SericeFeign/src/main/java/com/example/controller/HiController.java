package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.SchedualServiceHi;

@RestController
public class HiController {

	@Autowired
    private SchedualServiceHi schedualServiceHi;
	
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name, HttpSession session){
    	session.setAttribute("uid", "123");
    	System.out.println("test="+session.getId());
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
