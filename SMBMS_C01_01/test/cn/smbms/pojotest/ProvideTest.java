package cn.smbms.pojotest;

import static org.junit.Assert.*;

import java.io.InputStream;
 
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
 
public class ProvideTest {
	private Logger logger = Logger.getLogger(ProvideTest.class);
	@Test
	public void test() {
		String source ="mybatis-config-provide.xml";
		SqlSession session = null;
		int count =0;
		try {
			//获取配置文件
			InputStream is = Resources.getResourceAsStream(source);
			//获取工厂实例
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is); 
			//获取会话
			session = factory.openSession();
			//获取结果
			count = session.selectOne("cn.smbms.dao.user.ProvideMapper.count");
			logger.debug(count);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close(); 
		} 
	}

}
