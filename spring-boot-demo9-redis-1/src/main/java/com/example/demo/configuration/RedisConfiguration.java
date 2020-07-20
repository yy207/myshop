package com.example.demo.configuration;
  
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

 
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport{

	 
	    @Autowired
	    RedisTemplate redisTemplate;
	    // 配置缓存管理器
	    @Bean
	    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
	        LettuceConnectionFactory jedisConnectionFactory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
	        jedisConnectionFactory.setDatabase(2);      //指定dbindex
	        redisTemplate.setConnectionFactory(jedisConnectionFactory);
	        jedisConnectionFactory.resetConnection();

	        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
	        		.entryTtl(Duration.ofSeconds(60*20)) // 20分钟缓存失效
	                // 设置key的序列化方式
	                .
	                entryTtl(Duration.ofSeconds(10))
	                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
	                // 设置value的序列化方式
//	                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new FastJsonRedisSerializer(Object.class)))
	                // 不缓存null值
	                .disableCachingNullValues(); 
	        		
	        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory)
	                .cacheDefaults(config)
	                .transactionAware()
	                .build();
	        return redisCacheManager;
	    }
	} 
//@Configuration
//public class RedisCacheonfiguration extends CachingConfigurerSupport{
//	@Bean
//	public CacheManager getCachelManager(RedisTemplate<?, ?> redisTemplate){
//		RedisCacheManager manager = new RedisCacheManager(redisTemplate);
//		//置便存
//		manager.setDefaultExpiration(20);
//		Map<String, Long> expires = new HashMap<String, Long>();
//		expires .put("zyCache", 200L);
//		manager.setExpires(expires);  
//	return manager;
//	  
//	}
//}
