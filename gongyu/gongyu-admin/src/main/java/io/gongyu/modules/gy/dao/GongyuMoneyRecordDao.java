package io.gongyu.modules.gy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.gongyu.modules.gy.entity.GongyuMoneyRecordEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 保证金-记录
 * 
 * @author 
 * @email 
 * @date 2020-04-27 10:17:42
 */
@Mapper
public interface GongyuMoneyRecordDao extends BaseMapper<GongyuMoneyRecordEntity> {
	
}
