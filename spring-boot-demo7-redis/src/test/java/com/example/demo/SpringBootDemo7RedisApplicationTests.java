package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.com.example.demo.Redis;

@SpringBootTest
class SpringBootDemo7RedisApplicationTests {
	
	@Autowired
	private Redis redis;
	@Test
	void contextLoads() {
		redis.delee("name");
		
	}
	@Test
	void contextLoads_jedis() {
		redis.set("name", "sssss");
		
		System.out.println(redis.get("name"));
	}

}
