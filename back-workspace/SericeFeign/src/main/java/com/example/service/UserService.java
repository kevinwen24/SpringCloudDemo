package com.example.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.entity.User;

@Service
public class UserService {
  @Cacheable(value = "redis-key")
  public User getUserInfo(String name, String password) {
      System.out.println("无缓存时调用----数据库查询");
      return new User(name, password);
  }
}