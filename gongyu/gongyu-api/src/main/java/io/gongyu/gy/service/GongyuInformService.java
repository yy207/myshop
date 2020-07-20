package io.gongyu.gy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.gy.entity.responseParam.GongyuInformEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统通知
 *
 * @author 
 * @email 
 * @date 2020-04-29 16:27:53
 */
public interface GongyuInformService extends IService<GongyuInformEntity> {


    List<GongyuInformEntity> listInform(Integer userId);
}

