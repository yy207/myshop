package com.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.*;

public class JedisString {
    public static void main(String[] args) {
        try{
            Jedis jedis = new Jedis("127.0.0.1",6379);
            jedis.connect();
            //存储k-v
            jedis.set("name","张三");
            //查找 k-v
            String name =  jedis.get("name");
            System.out.println(name);
            //匹配符合规则的keys
            Set<String> keys = jedis.keys("*");
            for(String key : keys)
                System.out.println(key);
            //删除key
            jedis.del("name");

            //设置Hash哈希集合
            Map map = new HashMap();
            map.put("teacher","李四1");
            map.put("teacher","李四2");
            map.put("student","小明");
            jedis.hmset("names",map);
            List<String> list =   jedis.hmget("names","teacher");
            for(String li : list)
                    System.out.println("HashMap========="+li);
            //List集合
            List<String> lists = new ArrayList<String>();
            lists.add("520");
            lists.add("1314");
            jedis.lpush("love","520");
            jedis.lpush("love","1314");
            List list1 = jedis.lrange("love",0,100);
            System.out.println("list的元素==="+list1);
            jedis.del("love");

            jedis.

            jedis.flushAll();



            jedis.disconnect();
        }catch (Exception e){ System.out.println(e.getMessage());}
            }
        }
