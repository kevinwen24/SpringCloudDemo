package com.mwe.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mwe-service-client", fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
	
    @GetMapping("/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}