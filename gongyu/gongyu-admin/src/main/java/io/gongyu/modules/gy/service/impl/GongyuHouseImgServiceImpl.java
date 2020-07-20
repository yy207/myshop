package io.gongyu.modules.gy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.common.utils.Query;

import io.gongyu.modules.gy.dao.GongyuHouseImgDao;
import io.gongyu.modules.gy.entity.GongyuHouseImgEntity;
import io.gongyu.modules.gy.service.GongyuHouseImgService;


@Service("gongyuHouseImgService")
public class GongyuHouseImgServiceImpl extends ServiceImpl<GongyuHouseImgDao, GongyuHouseImgEntity> implements GongyuHouseImgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GongyuHouseImgEntity> page = this.page(
                new Query<GongyuHouseImgEntity>().getPage(params),
                new QueryWrapper<GongyuHouseImgEntity>()
        );

        return new PageUtils(page);
    }

}
