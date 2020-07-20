package com.example.demo.coontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class IndexController {

	@RequestMapping("index")
	public String index() {
		
		
		return "index";
	}
}
