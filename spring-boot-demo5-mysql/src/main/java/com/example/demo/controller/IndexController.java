package com.example.demo.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoDao;

@Controller
@RequestMapping("main")
public class IndexController {

	@Autowired
	private UserInfoDao userInfoDao;
	@RequestMapping("index")
	public String index(Model model) {
		 
		List<UserInfo> list = new ArrayList<UserInfo>();
		for (int i = 3; i <10; i++) {
			list.add(userInfoDao.getUserInfo(new UserInfo(i,"")));
		}
		model.addAttribute("info", userInfoDao.getUserInfo(new UserInfo(1,"")));
		model.addAttribute("list", list);
		return "index";
	}
}
