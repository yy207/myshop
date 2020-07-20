package com.jedis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class JedisDemo1 {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("localhost");
		System.out.println(jedis.ping());
		jedis.set("name","lala");
		String v = jedis.get("name");
		System.out.println(v);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "one");
		map.put("2", "two");
		jedis.hmset("nums", map);
		Map<String, String> o =  jedis.hgetAll("nums");
		
		System.out.println(o.get("1"));
		 
		
		jedis.lpush("names", "张三","李四");
		for (String string : jedis.lrange("names", 0, 100)) {
			System.out.println(string);
		};
		
		 
		
		
		
	}
}
