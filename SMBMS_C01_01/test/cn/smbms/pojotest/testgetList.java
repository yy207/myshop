package cn.smbms.pojotest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.smbms.utils.mybatisUtil;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;

public class testgetList {
	private Logger logger  = Logger.getLogger(testgetList.class);
	@Test
	public void test() {
		List<User> list = new ArrayList();
		SqlSession sqlsess = null;
		
		sqlsess = mybatisUtil.getSqlsession();
		//list = sqlsess.selectList("cn.smbms.dao.user.UserMapper.getuserlist");
		list = sqlsess.getMapper(UserMapper.class).getuserlist();
		logger.debug(list);
		for (User user : list) {
			logger.debug(user.getUserName()+"\t"+user.getUserPassword());
		}
	}

}
