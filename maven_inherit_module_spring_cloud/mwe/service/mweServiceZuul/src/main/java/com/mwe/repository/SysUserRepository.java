package com.mwe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mwe.entity.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long>{

	SysUser findByUsername(String username);
}
