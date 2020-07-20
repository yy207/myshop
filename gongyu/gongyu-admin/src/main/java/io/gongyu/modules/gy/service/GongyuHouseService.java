package io.gongyu.modules.gy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.modules.gy.entity.GongyuHouseEntity;
import io.gongyu.modules.gy.entity.HouseTypeEntity;
import io.gongyu.modules.gy.entity.PriceEntity;

import java.util.List;
import java.util.Map;

/**
 * 房源-房子信息
 *
 * @author 
 * @email 
 * @date 2020-04-17 15:41:56
 */
public interface GongyuHouseService extends IService<GongyuHouseEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<HouseTypeEntity> listType();

	List<PriceEntity> listPrice();
}

