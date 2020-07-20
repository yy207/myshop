package io.gongyu.modules.gy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.modules.gy.entity.GongyuReportJlEntity;

import java.util.Map;

/**
 * 举报记录
 *
 * @author 
 * @email 
 * @date 2020-04-27 10:13:37
 */
public interface GongyuReportJlService extends IService<GongyuReportJlEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

