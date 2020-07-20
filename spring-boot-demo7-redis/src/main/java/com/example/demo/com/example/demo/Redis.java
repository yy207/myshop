package com.example.demo.com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class Redis {

	@Autowired
	private StringRedisTemplate redisTemplate;
	public void set (String k ,String v) {
		//得到值操作类
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
	
		if(!this.redisTemplate.hasKey(k)) {
			ops.set(k, v);
		}else {
			System.out.println(k+" " + v);
		}
	}
	public String get(String k) { 
		return this.redisTemplate.opsForValue().get(k);
	}
	public void delee(String k) {
		this.redisTemplate.delete(k);
		
	}
	public void flush() {
	
	}
	
}
