package io.gongyu.modules.gy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.modules.gy.entity.GongyuAreaEntity;
import io.gongyu.modules.gy.entity.GongyuAreaMetroEntity;
import io.gongyu.modules.gy.entity.GongyuMetroEntity;

import java.util.List;

/**
 * 区域
 *
 * @author 
 * @email 
 * @date 2020-04-20 16:52:12
 */
public interface GongyuAreaService extends IService<GongyuAreaEntity> {

	List<GongyuMetroEntity> listMetro(Integer areaId);

	List<GongyuAreaMetroEntity> listMetroStation(Integer areaId, Integer metroId);
}

