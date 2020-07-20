package io.gongyu.login.service;

import com.baomidou.mybatisplus.extension.service.IService;

import io.gongyu.login.entity.ForgetPwdEntity;
import io.gongyu.login.entity.UpdateUserPwdEntity;
import io.gongyu.login.entity.UserEntity;
import io.gongyu.login.form.LoginForm;
import io.gongyu.login.form.RegisterForm;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户
 *
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @param request 
	 * @return        返回登录信息
	 */
	Map<String, Object> login(LoginForm form, HttpServletRequest request);

	UserEntity selectUser(String mobile);

	void updatePwd(ForgetPwdEntity forgetPwdEntity);

	void updateUserbyPwd(UpdateUserPwdEntity updateUserPwd);

	void saves(RegisterForm form);

}
