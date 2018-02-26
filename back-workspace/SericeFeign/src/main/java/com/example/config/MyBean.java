package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private StringRedisTemplate template;
    
    @Autowired
    public MyBean(StringRedisTemplate template) {
        this.template = template;
    }
}