package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.UserInfo;
import com.example.demo.dao.UserInfoDao;
@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	
	@Autowired
	private JdbcTemplate template;
	
	
	@Override
	public int insertUserInfo(UserInfo userInfo) {
		String sql ="insert into userinfo(name) values(?)";
		return template.update(sql,userInfo.getName() );
	}

	@Override
	public int deleteUserInfo(UserInfo userInfo) {
		String sql = "delete from userinfo where id = ?";
		return template.update(sql,userInfo.getId());
	}

	@Override
	public int updateUserInfo(UserInfo userInfo) {
		String sql = "update userinfo set name = ? where id = ?";
		return template.update(sql,userInfo.getName(),userInfo.getId());
	}

	@Override
	public UserInfo getUserInfo(UserInfo userInfo) {
		String sql = "select * from userinfo where id  = ?";
		
		
		return template.queryForObject(sql, new RowMapper<UserInfo>() {

			@Override
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				 UserInfo info = new UserInfo();
				 info.setId(rs.getInt(1));
				 info.setName(rs.getString(2));
				return info;
			} 
		}, userInfo.getId());
	}

}
