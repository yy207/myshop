package io.gongyu.modules.gy.dao;

import io.gongyu.modules.gy.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author 
 * @email 
 * @date 2020-04-21 18:11:59
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

	List<UserEntity> listCounselor();
	
}
