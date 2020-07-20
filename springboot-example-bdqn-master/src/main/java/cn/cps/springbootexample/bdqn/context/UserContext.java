package cn.cps.springbootexample.bdqn.context;

import cn.cps.springbootexample.bdqn.entity.user.vo.UserInfoVO;

/**
 * @Author: Cai Peishen
 * @Date: 2020/6/29 11:07
 * @Description: 解析Token 将用户信息放入UserContext中
 * ThreadLocal 生命周期为线程 每次请求为一个线程
 */
public class UserContext {
	/** 当前登陆用户Id */
	private static ThreadLocal<Long> userId = new ThreadLocal<Long>();
	/** 当前登陆用户Token */
	private static ThreadLocal<String> token = new ThreadLocal<String>();
	/** 当前登陆用户 */
	private static ThreadLocal<UserInfoVO> userInfoVO = new ThreadLocal<UserInfoVO>();

	private UserContext() {
	}

	public static Long getUserId() {
		return userId.get();
	}

	public static void setUserId(Long userId) {
		UserContext.userId.set(userId);
	}

	public static String getToken() {
		return UserContext.token.get();
	}

	public static void setToken(String token) {
		UserContext.token.set(token);
	}

	public static UserInfoVO getUserInfoVO() {
		return UserContext.userInfoVO.get();
	}

	public static void setUserInfoVO(UserInfoVO userInfoVO) {
		UserContext.userInfoVO.set(userInfoVO);
	}
}
