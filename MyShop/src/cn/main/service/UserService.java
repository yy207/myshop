package cn.main.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.main.pojo.User;

/**
 * 用户接口
 * @author sff
 *
 */
public interface UserService {
	//根据用户编码获取对象
	public User getUserByUserCode(String userCode);
	
	public int getAllUserCount(String userCode,String userName,Integer userRole,
			String idCard, String address, String realName, String sex,
			String email, String phone, String birthday,
			Integer loginState);
	//获取所有用户对象
	public List<User> getAllUser(String userCode,String userName,Integer userRole,
			String idCard, String address, String realName, String sex,
			String email, String phone, String birthday,
			Integer loginState, Integer currentIndex, Integer pageSize);
	//更改登录信息
	public boolean updateUserLastLoginTime(int id, String date, Integer loginState);
	//新增用户
	public boolean addUser(User user);
 
	//更新 邮箱 电话  密码
	/**
	 * 
	 * @param id
	 * @param userName 用户名
	 * @param email 邮箱
	 * @param phone 手机
	 * @param userPassword 密码 
	 * @param userPic 头像
	 * @return
	 */
	public int upateUserInfo(@Param(value="id")int id,
								@Param(value="userName")String userName,
								@Param(value="email")String email,
								@Param(value="phone")String phone,
								@Param(value="userPassword")String userPassword,
								@Param(value="userPic")String userPic);
	
}
