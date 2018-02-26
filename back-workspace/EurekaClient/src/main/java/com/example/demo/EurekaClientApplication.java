package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {

	@Value("${server.port}")
	private String port;
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
	@GetMapping("/hi")
	public String sayHi(@RequestParam String name, HttpServletRequest request) throws Exception {
		/*throw new Exception("error");*/
		HttpSession session = request.getSession();
		System.err.println("getRequestedSessionId="+request.getRequestedSessionId());
		System.err.println("sessionId="+session.getId());
		System.out.println("test="+session.getAttribute("uid"));
		return "Hi "+ name + ", I am from port: " + port;
	}
}
