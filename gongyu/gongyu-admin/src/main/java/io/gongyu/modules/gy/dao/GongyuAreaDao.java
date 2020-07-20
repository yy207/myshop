package io.gongyu.modules.gy.dao;

import io.gongyu.modules.gy.entity.GongyuAreaEntity;
import io.gongyu.modules.gy.entity.GongyuAreaMetroEntity;
import io.gongyu.modules.gy.entity.GongyuMetroEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 区域
 * 
 * @author 
 * @email 
 * @date 2020-04-20 16:52:12
 */
@Mapper
public interface GongyuAreaDao extends BaseMapper<GongyuAreaEntity> {

	List<GongyuMetroEntity> listMetro(Integer areaId);

	List<GongyuAreaMetroEntity> listMetroStation(Integer areaId, Integer metroId);
	
}
