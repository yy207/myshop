package io.gongyu.modules.gy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.modules.gy.entity.GongyuWxpayOrderEntity;


import java.util.Map;

/**
 * 微信交易记录
 *
 * @author 
 * @email 
 * @date 2020-05-11 09:33:39
 */
public interface GongyuWxpayOrderService extends IService<GongyuWxpayOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

