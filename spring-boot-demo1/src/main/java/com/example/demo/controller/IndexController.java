package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index/")
public class IndexController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Value(value = "${my.name}")
	private String name;
	@Value(value="${my.num}")
	private String value;
	
	@RequestMapping("index")
	public Map index() {
		System.out.println("hello world...");
		System.out.println("=======name:"+name);
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("value", value);
		System.out.println("------------------------");
		logger.info("this is a log==========");

	return map;
	}
}
