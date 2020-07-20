package com.example.demo.configuration;
  
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

//配置文件
@Configuration
public class RedisCacheConfiguration extends CachingConfigurerSupport{

	@Bean
	public  CacheManager getManager(RedisTemplate<?,?> tmp) {
		RedisCacheManager manager = new RedisCacheManager(cacheWriter, defaultCacheConfiguration);
		 manager.setd
		return manager;
	}
	
	
}
