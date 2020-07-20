package io.gongyu.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.gongyu.login.entity.ForgetPwdEntity;
import io.gongyu.login.entity.UpdateUserPwdEntity;
import io.gongyu.login.entity.UserEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

	UserEntity selectUser(String mobile);

	void updatePwd(ForgetPwdEntity forgetPwdEntity);

	void updateUserbyPwd(UpdateUserPwdEntity updateUserPwd);

}
