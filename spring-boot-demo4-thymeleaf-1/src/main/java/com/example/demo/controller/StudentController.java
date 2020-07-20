package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class StudentController {
	
	@RequestMapping("index")
	public String index(Model model) {
		
		model.addAttribute("name", "lala");
		List<String> list = new ArrayList<String>();
		list.add("no1");
		list.add("no2");
		list.add("no3"); 
		model.addAttribute("list", list);
		return "index";
	}
}
