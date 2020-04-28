import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import cn.main.dao.user.UserMapper;
import cn.main.pojo.User;
import cn.main.service.serviceimpl.UserServiceImpl;


public class TestUser {
	private Logger logger = Logger.getLogger(TestUser.class);
	@Test
	public void testUserLogin() {
		InputStream is;
		SqlSessionFactory factory = null ;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}	 
		SqlSession session= factory.openSession(false);
		User u = session.getMapper(UserMapper.class).getUserByUserCode("admin");  
		logger.debug(">>>>>>>>>>>"+u.getUserCode() + ""+u.getUserName());  
	} 
	
	@Test
	public void testSpring(){
		 
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			User u = ctx.getBean(UserServiceImpl.class).getUserByUserCode("admin");
			logger.debug("=============="+u.getUserCode()+u.getUserName());
		 
		
	}

















}
