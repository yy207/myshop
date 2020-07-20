package io.gongyu.login.controller;

import io.gongyu.common.RedisUtil;
import io.gongyu.common.exception.RRException;
import io.gongyu.common.utils.R;
import io.gongyu.common.validator.ValidatorUtils;
import io.gongyu.login.entity.ForgetPwdEntity;
import io.gongyu.login.entity.UserEntity;
import io.gongyu.login.form.RegisterForm;
import io.gongyu.login.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 注册接口
 *
 */
@RestController
@RequestMapping("/api/register")
@Api(tags = "注册接口")
public class ApiRegisterController {
	@Autowired
	private UserService userService;
	@Autowired
	private RedisUtil redisUtil;

	@PostMapping("/register")
	@ApiOperation("注册")
	public R register(@RequestBody RegisterForm form) {
		System.out.println(form);
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
				if (form.getPassword() != null) {
					user.setPassword(DigestUtils.shaHex(form.getPassword()));
				} else {
					throw new RRException("请输入密码");
				}
			} else {
				throw new RRException("手机号验证码错误");
			}
		} else {
			throw new RRException("验证码不能为空");
		}
		user.setCreateTime(new Date());
		userService.save(user);

		return R.ok();
	}

	//@PostMapping("/mobileRegister")
	//@ApiOperation("手机验证码注册")
	public R mobileRegister(RegisterForm form) {
		userService.saves(form);
		return R.ok();
	}

	@PostMapping("/forgetPwd")
	@ApiOperation("忘记密码")
	public R forgetPwd(@RequestBody ForgetPwdEntity forgetPwdEntity) {
		// 判断是否有此用户存在
		UserEntity user = userService.selectUser(forgetPwdEntity.getMobile());
		if (user != null) {
			String code = redisUtil.get(forgetPwdEntity.getMobile());
			// 测试
			// String code = redisUtil.get("admin");
			if (forgetPwdEntity.getVerifyCode() != null) {
				// 判断验证码是否一致
				if (forgetPwdEntity.getVerifyCode().equals(code)) {
					// 判断密码不能为空
					if (forgetPwdEntity.getPassword() != null && forgetPwdEntity.getPassword() != null) {
						// 判断两次密码是否一致
						if (forgetPwdEntity.getPassword().equals(forgetPwdEntity.getPasswordTwo())) {
							forgetPwdEntity.setPassword(DigestUtils.shaHex(forgetPwdEntity.getPassword()));
							// 进行修改密码
							userService.updatePwd(forgetPwdEntity);
							return R.ok();
						} else {
							throw new RRException("输入的两次密码不一致");
						}
					} else {
						throw new RRException("密码错误");
					}
				} else {
					throw new RRException("手机号验证码错误");
				}
			} else {
				throw new RRException("验证码不能为空");
			}
		} else {
			throw new RRException("此用户不存在");
		}
	}
}
