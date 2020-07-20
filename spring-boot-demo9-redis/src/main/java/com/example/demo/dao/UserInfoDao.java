package com.example.demo.dao;

 

import com.example.demo.bean.UserInfo;
  
public interface UserInfoDao {
	//insert 
	int insertUserInfo(UserInfo userInfo);
	
	//delete
	int deleteUserInfo(UserInfo userInfo);
	
	//update
	int updateUserInfo(UserInfo userInfo);
	
	UserInfo getUserInfo(UserInfo userInfo);
	
	UserInfo findById(Integer id);
	
}
