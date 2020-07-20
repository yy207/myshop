package io.gongyu.login.controller;


import io.gongyu.annotation.Login;
import io.gongyu.common.exception.RRException;
import io.gongyu.common.utils.R;
import io.gongyu.common.validator.ValidatorUtils;
import io.gongyu.login.entity.UpdateUserPwdEntity;
import io.gongyu.login.entity.UserEntity;
import io.gongyu.login.form.LoginForm;
import io.gongyu.login.service.TokenService;
import io.gongyu.login.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录接口
 */
@RestController
@RequestMapping("/api")
@Api(tags = "登录接口")
public class ApiLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    @ApiOperation("登录")
    public R login(LoginForm form, HttpServletRequest request) {
        //表单校验
        ValidatorUtils.validateEntity(form);
        if (form.getVerifyCode() == null) {
            form.setVerifyCode(null);
        }
        //用户登录
        Map<String, Object> map = userService.login(form, request);

        return R.ok(map);
    }

    /**
     * 修改密码
     *
     * @param
     * @return
     */
    @PostMapping("/updateUserbyPwd")
    @ApiOperation("修改用户密码")
    public R updateUserbyPwd(UpdateUserPwdEntity updateUserPwd) {
        //密码加密
        updateUserPwd.setPassword(DigestUtils.shaHex(updateUserPwd.getPassword()));
        updateUserPwd.setPasswordTwo(DigestUtils.shaHex(updateUserPwd.getPasswordTwo()));
        //获取用户信息
        UserEntity user = userService.selectUser(updateUserPwd.getMobile());
        //判断原原密码是否一样
        if (updateUserPwd.getPassword().equals(user.getPassword())) {
            userService.updateUserbyPwd(updateUserPwd);
        } else {
            throw new RRException("输入原密码错误");
        }
        return R.ok();

    }

    @Login
    @PostMapping("/logout")
    @ApiOperation("退出")
    public R logout(@ApiIgnore @RequestAttribute("userId") long userId) {
        tokenService.expireToken(userId);
        return R.ok();
    }

}
