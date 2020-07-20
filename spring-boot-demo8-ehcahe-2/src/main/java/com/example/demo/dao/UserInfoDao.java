package com.example.demo.dao;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.bean.UserInfo;
 
@MappedSuperclass
public interface UserInfoDao {
	//insert 
	int insertUserInfo(UserInfo userInfo);
	
	//delete
	int deleteUserInfo(UserInfo userInfo);
	
	//update
	int updateUserInfo(UserInfo userInfo);
	
	UserInfo getUserInfo(UserInfo userInfo);
	@Query("select * from userinfo where id = ?1")
	UserInfo findById(Integer id);
	
}
