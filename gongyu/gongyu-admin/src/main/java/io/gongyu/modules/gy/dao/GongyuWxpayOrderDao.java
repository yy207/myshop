package io.gongyu.modules.gy.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.gongyu.modules.gy.entity.GongyuWxpayOrderEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信交易记录
 * 
 * @author 
 * @email 
 * @date 2020-05-11 09:33:39
 */
@Mapper
public interface GongyuWxpayOrderDao extends BaseMapper<GongyuWxpayOrderEntity> {
	
}
