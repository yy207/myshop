package io.gongyu.modules.gy.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import io.gongyu.modules.gy.dao.GongyuAreaDao;
import io.gongyu.modules.gy.entity.GongyuAreaEntity;
import io.gongyu.modules.gy.entity.GongyuAreaMetroEntity;
import io.gongyu.modules.gy.entity.GongyuMetroEntity;
import io.gongyu.modules.gy.service.GongyuAreaService;


@Service("gongyuAreaService")
public class GongyuAreaServiceImpl extends ServiceImpl<GongyuAreaDao, GongyuAreaEntity> implements GongyuAreaService {

	@Override
	public List<GongyuMetroEntity> listMetro(Integer areaId) {
		return baseMapper.listMetro(areaId);
	}

	@Override
	public List<GongyuAreaMetroEntity> listMetroStation(Integer areaId, Integer metroId) {
		return baseMapper.listMetroStation(areaId,metroId);
	}

}
