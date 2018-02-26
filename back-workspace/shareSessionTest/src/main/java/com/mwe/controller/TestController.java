package com.mwe.controller;

import javax.servlet.http.HttpServletRequest;  

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.ResponseBody;  
  
@Controller  
public class TestController {  
  
    @RequestMapping(value="/getSessionId")  
    @ResponseBody  
    public String getSessionId(HttpServletRequest request){  
          
        Object o = request.getSession().getAttribute("springboot");  
        if(o == null){  
            o = "spring boot 牛逼了!!!有端口"+request.getLocalPort()+"生成";  
            request.getSession().setAttribute("springboot", o);  
        }  
        return "端口=" + request.getLocalPort() +  " sessionId=" + request.getSession().getId()
        		+"<br/>" + o + "<br/>"+ request.getSession().getAttribute("user");  
    }
     
    @GetMapping("/setUser")
    @ResponseBody
    public String setUser(HttpServletRequest request) {
    	request.getSession().setAttribute("user", "zhangsan");
    	return "ss";
    }
}  

