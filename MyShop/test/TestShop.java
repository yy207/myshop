import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import cn.main.dao.shop.ShopMapper;
import cn.main.pojo.Shop;
import cn.main.utils.MyBatis;

 

public class TestShop {
	private Logger logger = Logger.getLogger(getClass());
	@Test
	public void TestShop(){
		SqlSession sqlsession = MyBatis.getSqlSession();
		List<Shop> list = sqlsession.getMapper(ShopMapper.class).getShopList(null	, null, null, null, null, null, null, null,
								null, null, null, null, null, 0,5);
		for (Shop shop : list) {
			logger.debug(">>>>>>"+shop.getId()+"     "+shop.getName());
		}  
	}
}
