package com.mwe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mwe.service.SchedualServiceHi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;
    
    @GetMapping("/hi")
    public String sayHi(@RequestParam String name, HttpSession session){
    	session.setAttribute("A", "A");
    	System.out.println("user="+session.getAttribute("user"));
    	System.out.println("B="+session.getAttribute("B"));
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
