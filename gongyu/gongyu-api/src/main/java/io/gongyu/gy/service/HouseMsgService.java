package io.gongyu.gy.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import io.gongyu.gy.entity.HouseMsgEntity;
import io.gongyu.gy.entity.requestParam.HouseParamEntity;

public interface HouseMsgService extends IService<HouseMsgEntity>{

	List<HouseMsgEntity> listHouseMsg(HouseParamEntity houseParam);

}
