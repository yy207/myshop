package cn.main.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
/**
 * 会话工厂
 * @author sff
 *
 */
public class MyBatis {
	
	private static SqlSessionFactory factory;//会话工厂
	static{
		try {
			//读取配置文件
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			//构建工厂
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	//获取
	public static SqlSession getSqlSession(){
		return factory.openSession(false);
	}
	//关闭
	public static void closeSqlSession(SqlSession sqlSession){
		if(sqlSession!=null){
			sqlSession.close();
		}
	}
	
	
	
}
