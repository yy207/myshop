package io.gongyu.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.gongyu.common.RedisUtil;
import io.gongyu.common.exception.RRException;
import io.gongyu.common.validator.Assert;
import io.gongyu.common.validator.ValidatorUtils;
import io.gongyu.login.dao.UserDao;
import io.gongyu.login.entity.ForgetPwdEntity;
import io.gongyu.login.entity.TokenEntity;
import io.gongyu.login.entity.UpdateUserPwdEntity;
import io.gongyu.login.entity.UserEntity;
import io.gongyu.login.form.LoginForm;
import io.gongyu.login.form.RegisterForm;
import io.gongyu.login.service.TokenService;
import io.gongyu.login.service.UserService;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
	@Autowired
	private TokenService tokenService;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private UserService userService;

	@Override
	public UserEntity queryByMobile(String mobile) {
		return baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("mobile", mobile));
	}

	@Override
	public Map<String, Object> login(LoginForm form, HttpServletRequest request) {
		UserEntity user = queryByMobile(form.getMobile());
		// 判断用户是否存在
		if (user == null) {
			// 验证码登录
			// 判断验证码是否为空
			if (form.getVerifyCode() != null) {
				RegisterForm ss = new RegisterForm();
				ss.setMobile(form.getMobile());
				ss.setVerifyCode(form.getVerifyCode());
				// 进行注册
				saves(ss);
				UserEntity user2 = queryByMobile(form.getMobile());
				// 用户名存入该用户的session 中
				request.getSession().setAttribute("user", user2);
				// 获取登录token
				TokenEntity tokenEntity = tokenService.createToken(user2.getUserId());
				Map<String, Object> map = new HashMap<>(2);
				map.put("token", tokenEntity.getToken());
				map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());
				return map;
			} else {
				throw new RRException("验证码不能为空");
			}
		} else {
			// 判断用户是否禁止登陆
			if (user.getStatus() == 2) {
				throw new RRException("此用户禁止登陆");
			}
			Assert.isNull(user, "手机号或密码错误");
			// 用户名存入该用户的session 中
			request.getSession().setAttribute("user", user);
			// 判断验证码是否正确
			if (form.getVerifyCode() != null) {
				// 比对手机验证码是否正确
				String code = redisUtil.get(form.getMobile());
				// 测试
				// String code = redisUtil.get("admin");
				if (form.getVerifyCode().equals(code)) {

				} else {
					throw new RRException("手机号验证码错误");
				}
			} else {
				// 判断密码是否为空
				if (form.getPassword() != null) {
					// 密码错误
					if (!user.getPassword().equals(DigestUtils.shaHex(form.getPassword()))) {
						throw new RRException("密码错误");
					}
				} else {
					throw new RRException("密码不能为空");
				}
			}
			// 获取登录token
			TokenEntity tokenEntity = tokenService.createToken(user.getUserId());

			Map<String, Object> map = new HashMap<>(2);
			map.put("token", tokenEntity.getToken());
			map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());

			return map;
		}
	}

	@Override
	public UserEntity selectUser(String mobile) {
		return baseMapper.selectUser(mobile);
	}

	@Override
	public void updatePwd(ForgetPwdEntity forgetPwdEntity) {
		baseMapper.updatePwd(forgetPwdEntity);
	}

	@Override
	public void updateUserbyPwd(UpdateUserPwdEntity updateUserPwd) {
		baseMapper.updateUserbyPwd(updateUserPwd);
	}

	@Override
	public void saves(RegisterForm form) {
		// 表单校验
		ValidatorUtils.validateEntity(form);
		UserEntity user = new UserEntity();
		user.setUserImg(
				"http://igugua.oss-cn-beijing.aliyuncs.com/gongyu/user-img/2020-04/92ef0dd5-ee99-4e41-ac5a-97c051761b55.png");
		user.setMobile(form.getMobile());
		user.setUsername(form.getMobile());
		user.setSqStatus(1);
		user.setPosition(1);
		user.setStatus(1);
		// 判断验证码是否为null
		if (form.getVerifyCode() != null) {
			String code = redisUtil.get(form.getMobile());
			// 测试
			//String code = redisUtil.get("admin");
			if (form.getVerifyCode().equals(code)) {
				user.setPassword(DigestUtils.shaHex("147258"));
			} else {
				throw new RRException("手机号验证码错误");
			}
		} else {
			throw new RRException("验证码不能为空");
		}
		user.setCreateTime(new Date());
		userService.save(user);
	}

}
