package com.mwe;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class MweClientApplication {
	
	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(MweClientApplication.class, args);
	}
	
    @RequestMapping("/hi")
    public String home(@RequestParam String name,HttpSession session) {
    	System.out.println("user="+session.getAttribute("user"));
    	System.out.println("A="+session.getAttribute("A"));
    	System.out.println("B="+session.getAttribute("B"));
        return "hi " + name + ",i am from port:" + port;
    }
}
