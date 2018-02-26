package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.HelloService;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;
    
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
    
    @GetMapping("/helloRibbon")
    public String helloRibbon(){
        return "helloRibbon";
    }

}