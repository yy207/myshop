package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.example.demo.utils.Page;

import freemarker.template.Template;

public class AbstractJdbcDao {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	/**
	 * 最后一次更新的id
	 * @return
	 */
	public Long getLastId() {
		return jdbcTemplate.queryForObject("select last_insert_id() as id", Long.class);
	}
	/**
	 * 查询大型信息
	 * @param <T>
	 * @param sql
	 * @param clazz
	 * @param args
	 * @return
	 */
	public <T>T queryForobject(String sql, Class<T> clazz, Object ...args){
		Assert.hasText(sql,"SQL不能为空！");
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<T>(clazz),args);
	}
	/**
	 * 查询集合
	 * @param <T>
	 * @param sql
	 * @param clazz
	 * @param args
	 * @return
	 */
	public <T> List<T> queryForList(String sql, Class<T> clazz, Object ...args){
		Assert.hasText(sql,"SQL不能为空！");
		return jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<T>(clazz));
	}
	
//	public Page<Map<String,Object>> queryForPage(String sql,int pagecurrent,int pageSize){
//		Assert.hasText(sql,"SQL不能为空！"); 
//		Assert.isTrue(pagecurrent>=1,"pagecurrent必须大于等于1");
//		
//		
//	}
	
	
	
	
	
	
	
}
