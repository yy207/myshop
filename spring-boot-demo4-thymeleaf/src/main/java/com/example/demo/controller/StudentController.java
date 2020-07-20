package com.example.demo.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping; 

@Controller
@RequestMapping("stu")
public class StudentController {
		//private Logger logger = LoggerFactory.getLogger(getClass());
		@RequestMapping("show")
		public String name(Model model) {
			 
			model.addAttribute("msg","============");
			 
			return "show";
		}
 
}
