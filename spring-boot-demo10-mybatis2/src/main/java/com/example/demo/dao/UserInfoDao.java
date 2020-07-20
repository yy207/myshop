package com.example.demo.dao;

 

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CachePut;

import com.example.demo.bean.UserInfo;
 @Mapper
public interface UserInfoDao {
	  
	UserInfo findById(Integer id);
	
}
