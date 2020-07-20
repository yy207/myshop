package io.gongyu.gy.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.gongyu.gy.dao.AreaMetroDao;
import io.gongyu.gy.entity.responseParam.AreaMetroEntity;
import io.gongyu.gy.entity.responseParam.CityAddressEntity;
import io.gongyu.gy.entity.responseParam.CityAddressOneEntity;
import io.gongyu.gy.entity.responseParam.CityAddressTwoEntity;
import io.gongyu.gy.entity.responseParam.MetroEntity;
import io.gongyu.gy.entity.responseParam.MetroSunEntity;
import io.gongyu.gy.service.AreaMetroService;

@Service("areaMetroService")
public class AreaMetroServiceImpl extends ServiceImpl<AreaMetroDao, AreaMetroEntity> implements AreaMetroService {

	@Override
	public List<AreaMetroEntity> listAreaMetro() {
		List<AreaMetroEntity> list = baseMapper.listAreaMetro();
		for (AreaMetroEntity areaMetroEntity : list) {
			List<MetroEntity> listMetro = baseMapper.listMetro(areaMetroEntity.getAreaId());
			areaMetroEntity.setListMetro(listMetro);
			for (MetroEntity ss : listMetro) {
				List<MetroSunEntity> stationName = baseMapper.listStationName(areaMetroEntity.getAreaId(),
						ss.getMetroId());
				ss.setStationName(stationName);
			}
		}
		return list;
	}

	@Override
	public List<CityAddressEntity> listAddress() {
		// <!-- 省级查询 -->
		List<CityAddressEntity> list = baseMapper.listAddress();
		for (CityAddressEntity city : list) {
			// <!-- 市级查询 -->
			List<CityAddressOneEntity> listCity = baseMapper.listCity(city.getAreaId());
			city.setListCity(listCity);
			for (CityAddressOneEntity prefecture : listCity) {
				// <!-- 区县级查询 -->
				List<CityAddressTwoEntity> listPrefecture = baseMapper.listPrefecture(prefecture.getAreaId());
				prefecture.setListPrefecture(listPrefecture);
			}
		}
		return list;
	}
}
