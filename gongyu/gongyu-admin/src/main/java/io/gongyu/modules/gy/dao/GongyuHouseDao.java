package io.gongyu.modules.gy.dao;

import io.gongyu.modules.gy.entity.GongyuHouseEntity;
import io.gongyu.modules.gy.entity.HouseTypeEntity;
import io.gongyu.modules.gy.entity.PriceEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 房源-房子信息
 * 
 * @author 
 * @email 
 * @date 2020-04-17 15:41:56
 */
@Mapper
public interface GongyuHouseDao extends BaseMapper<GongyuHouseEntity> {

	List<HouseTypeEntity> listType();

	List<PriceEntity> listPrice();
	
}
