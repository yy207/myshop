package cn.smbms.pojotest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

public class testusermapper {
	private Logger logger = Logger.getLogger(testusermapper.class);
	@Test
	public void test() { 
		String resource = "mybatis-config.xml";
		int count =0;
		SqlSession session =null;
		//1.获取mybatis-config .xml输入流
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			//2.创建SQLSessionFactory
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is); 
			//3.创建SQLSession
			session = factory.openSession();
			//4.调用mapper文件对手进行操作,之前必须将mapper文件引入到mybatis-config.xml中
			count =session.selectOne("cn.smbms.dao.user.UserMapper.count");
			//5.
			logger.debug(count); 
		} catch (IOException e) { 
			e.printStackTrace();
		}finally{
			session.close(); 
		}                            
	}
	@Test
	public void testgetUserList() {
 		
		                          
	}

}
