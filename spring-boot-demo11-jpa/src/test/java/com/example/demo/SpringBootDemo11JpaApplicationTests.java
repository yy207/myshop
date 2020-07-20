package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoDao;

@SpringBootTest
class SpringBootDemo11JpaApplicationTests {
@Autowired
	private UserInfoDao dao;
	@Test
	void contextLoads() {
		
		
	}
	
	@Test
	void t_insert() {
		UserInfo i = new UserInfo();
		i.setName("张三S");
		for (int j = 0; j < 10; j++) {
			dao.save(i);
		} 
		
	}
	@Test
	void t_find() {
		 
//		List<UserInfo> lis =  dao.findAll();
//		
//		for (UserInfo userInfo : lis) {
//			System.out.println(userInfo.getId()+" "+userInfo.getName() );
//		}
		
//		List<UserInfo> lis = dao.findByNameLike("%张三%");
//		for (UserInfo userInfo : lis) {
//			System.out.println(userInfo.getId()+" "+userInfo.getName() );
//		}
		
	}
	@Test
	void t_update() {
		UserInfo i = new UserInfo();
		i.setName("张大仙2");
		i.setId(2);
		dao.save(i);
		 
	}
	@Test
	void t_delete() {
		UserInfo i = new UserInfo();
		i.setName("张大仙2");
		i.setId(2);
		dao.deleteById(1);
		 
	}
	@Test
	void find() {
		 
		List<UserInfo> lis = dao.findByName("%张%");
		for (UserInfo userInfo : lis) {
			System.out.println(userInfo.getId()+" "+userInfo.getName() );
		}
	}
	@Test
	void page() {
		 
		Pageable page =PageRequest.of(1, 2);
		Page<UserInfo> pages = dao.findByNameLike("%张三%", page);
		
		for (UserInfo userInfo : pages) {
			System.out.println(userInfo.getId()+" "+userInfo.getName());
		}
		
	 
	}
	

}
