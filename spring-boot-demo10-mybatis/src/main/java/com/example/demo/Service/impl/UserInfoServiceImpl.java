package com.example.demo.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.Service.UserInfoService;
import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoDao;
@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoDao dao;
	@Cacheable(cacheNames = "zy")
	@Override
	public UserInfo findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

}
