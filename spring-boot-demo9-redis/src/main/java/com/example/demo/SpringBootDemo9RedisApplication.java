package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching//启动缓存
@SpringBootApplication
public class SpringBootDemo9RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo9RedisApplication.class, args);
	}

}
