package cn.main.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.beust.jcommander.Parameter;

import cn.main.pojo.User;

/**
 * 用户接口
 * @author sff
 *
 */
public interface UserMapper {
	/**
	 * 根据用户编码获取用户对象
	 * @param userCode 用户编码
	 * @return 用户对象
	 */
	public User getUserByUserCode(@Param(value="userCode")String userCode);
	
	public User getUserByUserId(@Param(value="id")String Id);
	
	public int getAllUserCount(@Param(value="userCode")String userCode,
			@Param(value="userName")String userName,
			@Param(value="userRole")Integer userRole,
			@Param(value="idCard")String idCard,
			@Param(value="address")String address,
			@Param(value="realName")String realName,
			@Param(value="sex")String sex,
			@Param(value="email")String email,
			@Param(value="phone")String phone,
			@Param(value="birthday")String birthday,
			@Param(value="loginState")Integer loginState);
	
	//所有用户信息
	public List<User> getAllUser(
			@Param(value="userCode")String userCode,
			@Param(value="userName")String userName,
			@Param(value="userRole")Integer userRole,
			@Param(value="idCard")String idCard,
			@Param(value="address")String address,
			@Param(value="realName")String realName,
			@Param(value="sex")String sex,
			@Param(value="email")String email,
			@Param(value="phone")String phone,
			@Param(value="birthday")String birthday,
			@Param(value="loginState")Integer loginState,
			@Param(value="from")Integer currentIndex,
			@Param(value="pageSize")Integer pageSize);
	
	//更改登录时间
	public int updateUserLastLoginTime(@Param(value="id")int id,
							@Param(value="date")String date,
							@Param(value="state")Integer loginState); 
	
	//插入用户
	public int addUser(@Param(value="user")User user);
}
