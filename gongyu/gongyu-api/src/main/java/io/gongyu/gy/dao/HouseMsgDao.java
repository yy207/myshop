package io.gongyu.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import io.gongyu.gy.entity.HouseMsgEntity;
import io.gongyu.gy.entity.requestParam.HouseParamEntity;

@Mapper
public interface HouseMsgDao extends BaseMapper<HouseMsgEntity>{

	List<HouseMsgEntity> listHouseMsg(HouseParamEntity houseParam);

}
