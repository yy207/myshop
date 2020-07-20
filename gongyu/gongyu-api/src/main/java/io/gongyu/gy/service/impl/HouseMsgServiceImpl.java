package io.gongyu.gy.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.gongyu.gy.dao.HouseMsgDao;
import io.gongyu.gy.entity.HouseMsgEntity;
import io.gongyu.gy.entity.requestParam.HouseParamEntity;
import io.gongyu.gy.service.HouseMsgService;
@Service("houseMsgService")
public class HouseMsgServiceImpl extends ServiceImpl<HouseMsgDao, HouseMsgEntity> implements HouseMsgService{

	@Override
	public List<HouseMsgEntity> listHouseMsg(HouseParamEntity houseParam) {
		return baseMapper.listHouseMsg(houseParam);
	}

}
