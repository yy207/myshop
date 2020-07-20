package com.example.demo.dao;

 

import java.util.List;

import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.bean.UserInfo;
  
public interface UserInfoDao extends JpaRepository<UserInfo,Integer>{
	
	@Query(value = " select u from userinfo u where u.name like ?1")
	List<UserInfo> findByName(String name);
	 
	//List<UserInfo> findByNameLike(String name);
	
	public Page<UserInfo> findByNameLike(String name,Pageable page);
	
}
