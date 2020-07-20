package io.gongyu.modules.gy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.modules.gy.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author 
 * @email 
 * @date 2020-04-21 18:11:59
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<UserEntity> listCounselor();
}

