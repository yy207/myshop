package io.gongyu.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.modules.sys.entity.SysDictEntity;

import java.util.Map;

/**
 * 数据字典
 *
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

