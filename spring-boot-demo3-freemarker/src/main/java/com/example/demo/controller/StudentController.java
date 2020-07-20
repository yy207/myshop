package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.Student;

@Controller
@RequestMapping("stu")
public class StudentController {
		private Logger logger = LoggerFactory.getLogger(getClass());
		@RequestMapping("show")
		public String name(Model model,HttpServletRequest request,HttpServletResponse response) {
			Student stu = new Student();
			stu.setAge(23);
			stu.setName("lala"); 
			model.addAttribute("stu",stu);
			model.addAttribute("str", "hello world !");
			request.setAttribute("str", "hello!");
			logger.debug("-------------------");
			List<Student> list = new ArrayList<Student>();
			for (int i = 0; i < 3; i++) {
				Student s = new Student("S_"+i,i);
				list.add(s);
			}
			model.addAttribute("list", list);
			
			return "show";
		}
//		@RequestMapping("show")
//		public ModelAndView show(Model model,HttpServletRequest request,HttpServletResponse response) {
//			ModelAndView mv = new ModelAndView();
//			mv.setViewName("show");
//			Student stu = new Student();
//			stu.setAge(23);
//			stu.setName("lala");
//			model.addAttribute("stu",stu);
//			model.addAttribute("str", "hello world !");
//			request.setAttribute("str", "hello!");
//			logger.debug("-------------------");
//			mv.addObject("str", "mv===");
//			return mv;
//		}
}
