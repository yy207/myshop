package com.example.demo.dao;

 

import org.springframework.cache.annotation.CachePut;

import com.example.demo.bean.UserInfo;
  
public interface UserInfoDao {
	//insert 
	int insertUserInfo(UserInfo userInfo);
	
	//delete
	int deleteUserInfo(UserInfo userInfo);
	
	//update
	int updateUserInfo(UserInfo userInfo);
	
	UserInfo getUserInfo(UserInfo userInfo);
	@CachePut(cacheNames = "zy",key = "#p0.id")
	UserInfo findById(Integer id);
	
}
