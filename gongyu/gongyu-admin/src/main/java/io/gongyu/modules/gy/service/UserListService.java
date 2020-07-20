package io.gongyu.modules.gy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.gongyu.common.utils.PageUtils;
import io.gongyu.modules.gy.entity.UserListEntity;

import java.util.Map;

/**
 * 用户
 *
 * @author 
 * @email 
 * @date 2020-04-29 13:07:53
 */
public interface UserListService extends IService<UserListEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

