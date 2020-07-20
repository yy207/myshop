package io.gongyu.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.gongyu.gy.entity.responseParam.AreaMetroEntity;
import io.gongyu.gy.entity.responseParam.CityAddressEntity;
import io.gongyu.gy.entity.responseParam.CityAddressOneEntity;
import io.gongyu.gy.entity.responseParam.CityAddressTwoEntity;
import io.gongyu.gy.entity.responseParam.MetroEntity;
import io.gongyu.gy.entity.responseParam.MetroSunEntity;

@Mapper
public interface AreaMetroDao extends BaseMapper<AreaMetroEntity>{

	List<AreaMetroEntity> listAreaMetro();

	List<MetroEntity> listMetro(Integer areaId);

	List<MetroSunEntity> listStationName(Integer areaId, Integer metroId);

	List<CityAddressEntity> listAddress();

	List<CityAddressOneEntity> listCity(Integer areaId);

	List<CityAddressTwoEntity> listPrefecture(Integer areaId);
}
