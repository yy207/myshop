package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class BaseController implements ErrorController {

	/**
	 * 出现错误，实现getErrorPath方法
	 */
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "error/error";
	}
	@RequestMapping	
	public  String error() {
		return getErrorPath();
	}

}
