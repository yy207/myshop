package io.gongyu.modules.gy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.modules.gy.entity.GongyuHouseImgEntity;

import java.util.Map;

/**
 * 房源图片
 *
 * @author 
 * @email 
 * @date 2020-04-22 15:23:52
 */
public interface GongyuHouseImgService extends IService<GongyuHouseImgEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

