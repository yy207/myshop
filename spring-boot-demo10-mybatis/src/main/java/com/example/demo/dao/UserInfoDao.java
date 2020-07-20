package com.example.demo.dao;

 

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CachePut;

import com.example.demo.bean.UserInfo;
 @Mapper
public interface UserInfoDao {
	  
	@Select("select * from userinfo where id = #{id}")
	@Results(
			value= {
					@Result(column = "id",property = "id"),
					@Result(column="name",property = "name")
			})
	UserInfo findById(Integer id);
	
}
