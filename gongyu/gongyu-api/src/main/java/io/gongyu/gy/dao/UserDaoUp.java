package io.gongyu.gy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.gongyu.gy.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author 
 * @email 
 * @date 2020-04-24 10:30:11
 */
@Mapper
public interface UserDaoUp extends BaseMapper<UserEntity> {
	
}
