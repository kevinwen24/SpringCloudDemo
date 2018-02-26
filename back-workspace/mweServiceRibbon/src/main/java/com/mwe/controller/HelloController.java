package com.mwe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mwe.service.HelloService;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;
    
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }

    @GetMapping("/socialService")
    public String socialService(String name) {
    	return "hello, "+ name + ",I am social service";
    }
}