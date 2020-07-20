package io.gongyu.login.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.gongyu.login.entity.TokenEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Token
 *
 */
@Mapper
public interface TokenDao extends BaseMapper<TokenEntity> {
	
}
