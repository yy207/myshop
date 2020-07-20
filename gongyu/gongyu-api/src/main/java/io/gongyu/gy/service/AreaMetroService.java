package io.gongyu.gy.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import io.gongyu.gy.entity.responseParam.AreaMetroEntity;
import io.gongyu.gy.entity.responseParam.CityAddressEntity;

public interface AreaMetroService extends IService<AreaMetroEntity>{

	List<AreaMetroEntity> listAreaMetro();

	List<CityAddressEntity> listAddress();
}
