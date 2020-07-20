package com.example.demo.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.UserInfoService;
import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoDao;

@Controller
@RequestMapping("main")
public class IndexController {

	@Autowired
	private UserInfoService service;
	
	@RequestMapping("index")
	public String index(Model model) {
		 System.out.print("**************");
		 return "index";
	}
	
	
	@RequestMapping("show")
	public String show(Integer id,Model model) {
		System.out.println(id+"===========================");
		 UserInfo user = service.findById(id);
		 model.addAttribute("user", user);
		 model.
		 return "index";
	}
	
	
}
