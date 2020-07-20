package io.gongyu.modules.gy.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.Query;

import io.gongyu.modules.gy.dao.GongyuHouseDao;
import io.gongyu.modules.gy.entity.GongyuHouseEntity;
import io.gongyu.modules.gy.entity.HouseTypeEntity;
import io.gongyu.modules.gy.entity.PriceEntity;
import io.gongyu.modules.gy.service.GongyuHouseService;


@Service("gongyuHouseService")
public class GongyuHouseServiceImpl extends ServiceImpl<GongyuHouseDao, GongyuHouseEntity> implements GongyuHouseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GongyuHouseEntity> page = this.page(
                new Query<GongyuHouseEntity>().getPage(params),
                new QueryWrapper<GongyuHouseEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<HouseTypeEntity> listType() {
		return baseMapper.listType();
	}

	@Override
	public List<PriceEntity> listPrice() {
		return baseMapper.listPrice();
	}

}
