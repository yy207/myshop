package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoDao;

@SpringBootTest
class SpringBootDemoMysqlApplicationTests {
	@Autowired
	UserInfoDao userInfoDao;
	
	@Test
	void contextLoads() {
		
		
	}
	@Test
	void insert_() {
		UserInfo userInfo = new UserInfo();
		
		
		for (int i = 0; i < 10; i++) {
			userInfo.setName("张三"+i);
			int num = userInfoDao.insertUserInfo(userInfo);
			System.out.println(num);
		}
		
		
		
	}
	
	@Test
	void update_() {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(2);
		userInfo.setName("张三2");
		int num = userInfoDao.updateUserInfo(userInfo);
		System.out.println(num);
	}
	@Test
	void delete_() {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(2);
		userInfo.setName("张三2");
		int num = userInfoDao.deleteUserInfo(userInfo);
		System.out.println(num);
	}
	@Test
	void selete_() {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(1);
		userInfo.setName("张三2");
		UserInfo num = userInfoDao.getUserInfo(userInfo);
		System.out.println(num.getId()+"  "+num.getName());
	}

}
