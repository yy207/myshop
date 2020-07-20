package io.gongyu.modules.gy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.modules.gy.entity.GongyuMoneyRecordEntity;

import java.util.Map;

/**
 * 保证金-记录
 *
 * @author 
 * @email 
 * @date 2020-04-27 10:17:42
 */
public interface GongyuMoneyRecordService extends IService<GongyuMoneyRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

