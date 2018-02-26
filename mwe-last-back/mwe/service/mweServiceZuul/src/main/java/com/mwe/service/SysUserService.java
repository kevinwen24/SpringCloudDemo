package com.mwe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mwe.entity.SysUser;
import com.mwe.repository.SysUserRepository;

@Service
public class SysUserService{
	
    @Autowired
    SysUserRepository userRepository;

    public SysUser findUserByUsername(String userName) {
    	return userRepository.findByUsername(userName);
    }
}