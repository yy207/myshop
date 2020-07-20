package com.smbms.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class mybatisUtil {
	private static SqlSessionFactory factory=null;
	static{
		try {
			//1.获取文件流
			InputStream is  = Resources.getResourceAsStream("mybatis-config.xml");
			//2.获取 factory 
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static SqlSession getSqlsession(){
		return factory.openSession(false);
	}
	public static void closeSqlSession(SqlSession session ){
		if(session!=null){
			session.close();
		}
	}



}
